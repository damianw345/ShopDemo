package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class IceCreamDto {

    private Long iceCreamId;
    private String sauce;
    private String dressing;
    private List<String> flavours;
}