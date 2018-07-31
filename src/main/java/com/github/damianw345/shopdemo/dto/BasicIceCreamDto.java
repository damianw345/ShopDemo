package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicIceCreamDto {

    private Long iceCreamId;
    private String name;
    private String price;
}
