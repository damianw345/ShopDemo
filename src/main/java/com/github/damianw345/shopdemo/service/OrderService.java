package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.IceCream;
import com.github.damianw345.shopdemo.dao.Order;
import com.github.damianw345.shopdemo.dto.IceCreamDto;
import com.github.damianw345.shopdemo.dto.OrderDto;
import com.github.damianw345.shopdemo.mapper.IceCreamMapper;
import com.github.damianw345.shopdemo.mapper.OrderMapper;
import com.github.damianw345.shopdemo.repository.IceCreamRepository;
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
    private final IceCreamRepository iceCreamRepository;
    private final OrderMapper orderMapper;
    private final IceCreamMapper iceCreamMapper;

    public List<OrderDto> getOrders() {

        List<Order> orders = Optional.ofNullable(orderRepository.findAll())
                .orElseThrow(NotFoundException::new);

        return orders.stream().map(orderMapper::toDto).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto addOrder(OrderDto dto) {

        Order order = Optional.ofNullable(dto)
                .map(orderMapper::toEntity)
                .map(orderRepository::save)
                .orElseThrow(BadRequestException::new);


        for(IceCreamDto iceCreamDto : dto.getIceCreams()){
            IceCream iceCream = iceCreamMapper.toEntity(iceCreamDto);
            iceCream.setOrder(order);
            iceCreamRepository.save(iceCream);
            iceCreamDto.setIceCreamId(iceCream.getIceCreamId());
        }

        dto.setOrderId(order.getOrderId());

        return dto;
    }

    public OrderDto getOrder(Long id) {
        return Optional.ofNullable(orderRepository.getOne(id))
                .map(orderMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public OrderDto updateOrder(OrderDto dto, Long id) {

        dto.setOrderId(id);

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
