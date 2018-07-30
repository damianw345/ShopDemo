package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dto.OrderDto;
import com.github.damianw345.shopdemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderService {

    private final OrderRepository orderRepository;

    public Page<OrderDto> getOrders(Pageable pageable) {
        return null;
    }

    public OrderDto addOrder(OrderDto dto) {
        return null;

    }

    public OrderDto getOrder(String id) {
        return null;

    }

    public OrderDto updateOrder(OrderDto dto, String id) {
        return null;

    }

    public void deleteOrder(String id) {

    }

}
