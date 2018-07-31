package com.github.damianw345.shopdemo.mapper;

import com.github.damianw345.shopdemo.dao.Food;
import com.github.damianw345.shopdemo.dao.FoodsToOrders;
import com.github.damianw345.shopdemo.dao.Order;
import com.github.damianw345.shopdemo.dto.FoodDto;
import com.github.damianw345.shopdemo.dto.OrderDto;
import com.github.damianw345.shopdemo.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderMapper {

    private final FoodMapper foodMapper;
    private final FoodRepository foodRepository;

    public OrderDto toDto(Order order){

        List<FoodDto> foodDtos = order.getFoodsToOrders()
                .stream()
                .map(FoodsToOrders::getFood)
                .map(foodMapper::toDto)
                .collect(Collectors.toList());

        return new OrderDto(order.getOrderId(), order.getIsFinished(), foodDtos);
    }

    public Order toEntity(OrderDto orderDto){

        Order order = new Order();
//        order.setOrderId(orderDto.getOrderId());
        order.setIsFinished(orderDto.getIsFinished());
        order.setFoodsToOrders(mapFoodDtoToFoodsToOrdersEntity(orderDto, order, new HashSet<>()));

        return order;
    }

    public Order updateEntity(Order order, OrderDto orderDto){

        order.setOrderId(orderDto.getOrderId());
        order.setIsFinished(orderDto.getIsFinished());
        order.setFoodsToOrders(mapFoodDtoToFoodsToOrdersEntity(orderDto, order, order.getFoodsToOrders()));

        return order;
    }

    public List<OrderDto> toDtoList(List<Order> orders) {
        return orders.stream().map(this::toDto).collect(Collectors.toList());
    }

    private Set<FoodsToOrders> mapFoodDtoToFoodsToOrdersEntity(OrderDto orderDto, Order order, Set<FoodsToOrders> foodsToOrdersSet){

        for(FoodDto foodDto : orderDto.getFoodDtos()){
            Food food = foodRepository.getOne(foodDto.getFoodId());

            FoodsToOrders foodsToOrders = new FoodsToOrders();
            foodsToOrders.setOrder(order);
            foodsToOrders.setFood(food);
            foodsToOrders.setFoodAmount(foodDto.getAmount());

            foodsToOrdersSet.add(foodsToOrders);
        }
        return foodsToOrdersSet;
    }
}
