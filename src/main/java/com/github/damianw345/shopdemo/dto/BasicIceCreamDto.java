package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicIceCreamDto {

    private Long iceCreamId;
    private String name;
    private String price;
    private Integer sauceId;
    private Integer dressingId;
    private List<Integer> flavourIds;

}
