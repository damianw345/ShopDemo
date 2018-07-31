package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FoodDto extends BasicFoodDto {

    private Integer amount;

    public FoodDto(Long foodId, String name, Integer amount, String price){
        super(foodId, name, price);
        this.amount = amount;
    }
}
