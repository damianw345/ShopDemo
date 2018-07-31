package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IceCreamDto extends BasicIceCreamDto {

    private Integer amount;

    public IceCreamDto(Long iceCreamId, String name, Integer amount, String price){
        super(iceCreamId, name, price);
        this.amount = amount;
    }
}
