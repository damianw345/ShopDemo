package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IceCreamDto extends BasicIceCreamDto {

    private Integer amount;

    public IceCreamDto(Long iceCreamId, String name, Integer amount, String price, Integer sauceId, Integer dressingId, List<Integer> flavoursIds){
        super(iceCreamId, name, price, sauceId, dressingId, flavoursIds);
        this.amount = amount;
    }
}
