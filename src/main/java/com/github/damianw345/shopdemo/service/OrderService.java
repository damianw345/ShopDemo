package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Order;
import com.github.damianw345.shopdemo.dto.OrderDto;
import com.github.damianw345.shopdemo.mapper.OrderMapper;
import com.github.damianw345.shopdemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

//    public List<OrderDto> getOrders() {
//
//        return Optional.ofNullable(orderRepository.findAll())
//                .map(orderMapper::toDtoList)
//                .orElseThrow(NotFoundException::new);
//    }

    public List<OrderDto> getOrders() {

        List<Order> orders = Optional.ofNullable(orderRepository.findAll())
                .orElseThrow(NotFoundException::new);

        return orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto addOrder(OrderDto dto) {

        return Optional.ofNullable(dto)
                .map(orderMapper::toEntity)
                .map(orderRepository::save)
                .map(orderMapper::toDto)
                .orElseThrow(BadRequestException::new);
    }

    public OrderDto getOrder(Long id) {
        return Optional.ofNullable(orderRepository.getOne(id))
                .map(orderMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public OrderDto updateOrder(OrderDto dto, Long id) {

        return Optional.ofNullable(orderRepository.getOne(id))
                .map(order ->  orderMapper.updateEntity(order, dto))
                .map(orderRepository::save)
                .map(orderMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
