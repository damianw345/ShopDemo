package com.github.damianw345.shopdemo.mapper;

import com.github.damianw345.shopdemo.dao.Food;
import com.github.damianw345.shopdemo.dto.BasicFoodDto;
import com.github.damianw345.shopdemo.dto.FoodDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FoodMapper {

    public BasicFoodDto toBasicDto(Food food){
        return new BasicFoodDto(food.getFoodId(), food.getName(), food.getPrice());
    }

    public FoodDto toDto(Food food){
        return new FoodDto(food.getFoodId(), food.getName(), null, food.getPrice());
    }

    public Food toEntity(FoodDto dto){

        Food food = new Food();
        food.setFoodId(dto.getFoodId());
        food.setName(dto.getName());
        food.setPrice(dto.getPrice());

        return food;
    }

    public Food updateEntity(Food food, FoodDto foodDto){

        food.setName(foodDto.getName());
        food.setPrice(foodDto.getPrice());

        return food;
    }

    public List<BasicFoodDto> toBasicDtoList(List<Food> foods) {
        return foods.stream().map(this::toBasicDto).collect(Collectors.toList());
    }

    public List<BasicFoodDto> toDtoList(List<Food> foods) {
        return foods.stream().map(this::toDto).collect(Collectors.toList());
    }
}
