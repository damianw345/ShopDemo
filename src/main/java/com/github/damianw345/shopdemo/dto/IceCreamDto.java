package com.github.damianw345.shopdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IceCreamDto {

    private Long iceCreamId;
    private String sauce;
    private String dressing;
    private List<String> flavours;
}