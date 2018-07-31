package com.github.damianw345.shopdemo.mapper;

import com.github.damianw345.shopdemo.dao.IceCream;
import com.github.damianw345.shopdemo.dao.IceCreamsToOrders;
import com.github.damianw345.shopdemo.dao.Order;
import com.github.damianw345.shopdemo.dto.IceCreamDto;
import com.github.damianw345.shopdemo.dto.OrderDto;
import com.github.damianw345.shopdemo.repository.IceCreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderMapper {

    private final IceCreamMapper iceCreamMapper;
    private final IceCreamRepository iceCreamRepository;

    public OrderDto toDto(Order order){

        List<IceCreamDto> iceCreamDtos = order.getIceCreamsToOrders()
                .stream()
                .map(IceCreamsToOrders::getIceCream)
                .map(iceCreamMapper::toDto)
                .collect(Collectors.toList());

        return new OrderDto(order.getOrderId(), order.getIsFinished(), iceCreamDtos);
    }

    public Order toEntity(OrderDto orderDto){

        Order order = new Order();
        order.setIsFinished(orderDto.getIsFinished());
        order.setIceCreamsToOrders(mapIceCreamDtoToIceCreamsToOrdersEntity(orderDto, order, new HashSet<>()));

        return order;
    }

    public Order updateEntity(Order order, OrderDto orderDto){

        order.setIsFinished(orderDto.getIsFinished());
        order.setIceCreamsToOrders(mapIceCreamDtoToIceCreamsToOrdersEntity(orderDto, order, order.getIceCreamsToOrders()));

        return order;
    }

    public List<OrderDto> toDtoList(List<Order> orders) {
        return orders.stream().map(this::toDto).collect(Collectors.toList());
    }

    private Set<IceCreamsToOrders> mapIceCreamDtoToIceCreamsToOrdersEntity(OrderDto orderDto, Order order, Set<IceCreamsToOrders> iceCreamsToOrdersSet){


        if(Objects.nonNull(orderDto.getIceCreamDtos())){
            for(IceCreamDto iceCreamDto : orderDto.getIceCreamDtos()){
                IceCream iceCream = iceCreamRepository.getOne(iceCreamDto.getIceCreamId());

                IceCreamsToOrders iceCreamsToOrders = new IceCreamsToOrders();
                iceCreamsToOrders.setOrder(order);
                iceCreamsToOrders.setIceCream(iceCream);
                iceCreamsToOrders.setIceCreamAmount(iceCreamDto.getAmount());

                iceCreamsToOrdersSet.add(iceCreamsToOrders);
            }
        }

        return iceCreamsToOrdersSet;
    }
}
