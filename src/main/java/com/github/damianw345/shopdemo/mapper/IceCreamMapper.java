package com.github.damianw345.shopdemo.mapper;

import com.github.damianw345.shopdemo.dao.Flavour;
import com.github.damianw345.shopdemo.dao.IceCream;
import com.github.damianw345.shopdemo.dto.BasicIceCreamDto;
import com.github.damianw345.shopdemo.dto.IceCreamDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IceCreamMapper {

    public BasicIceCreamDto toBasicDto(IceCream iceCream){

        List<Integer> flavorsIds = iceCream.getFlavours().stream().map(Flavour::getFlavourId).collect(Collectors.toList());

        return new BasicIceCreamDto(iceCream.getIceCreamId(), iceCream.getName(), iceCream.getPrice(), iceCream.getSauce().getSauceId(), iceCream.getDressing().getDressingId(), flavorsIds);
    }

    public IceCreamDto toDto(IceCream iceCream){

        List<Integer> flavorsIds = iceCream.getFlavours().stream().map(Flavour::getFlavourId).collect(Collectors.toList());

        return new IceCreamDto(iceCream.getIceCreamId(), iceCream.getName(), null, iceCream.getPrice(), iceCream.getSauce().getSauceId(), iceCream.getDressing().getDressingId(), flavorsIds);
    }

    public IceCream toEntity(IceCreamDto dto){

        IceCream iceCream = new IceCream();
        iceCream.setIceCreamId(dto.getIceCreamId());
        iceCream.setName(dto.getName());
        iceCream.setPrice(dto.getPrice());

        return iceCream;
    }

    public IceCream updateEntity(IceCream iceCream, IceCreamDto iceCreamDto){

        iceCream.setName(iceCreamDto.getName());
        iceCream.setPrice(iceCreamDto.getPrice());

        return iceCream;
    }

    public List<BasicIceCreamDto> toBasicDtoList(List<IceCream> iceCreams) {
        return iceCreams.stream().map(this::toBasicDto).collect(Collectors.toList());
    }

//    public List<BasicIceCreamDto> toDtoList(List<IceCream> iceCreams) {
//        return iceCreams.stream().map(this::toDto).collect(Collectors.toList());
//    }
}
