package com.github.damianw345.shopdemo.mapper;

import com.github.damianw345.shopdemo.dao.IceCream;
import com.github.damianw345.shopdemo.dto.IceCreamDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class IceCreamMapper {


    public IceCreamDto toDto(IceCream iceCream){

        List<String> flavours = Stream.of(iceCream.getFirstFlavour(), iceCream.getSecondFlavour()).collect(Collectors.toList());

        return new IceCreamDto(iceCream.getIceCreamId(), iceCream.getSauce(), iceCream.getDressing(), flavours);
    }

    public List<IceCreamDto> toDtoList(List<IceCream> iceCreams) {
        return iceCreams.stream().map(this::toDto).collect(Collectors.toList());
    }

    public IceCream toEntity(IceCreamDto dto){

        String secondFlavour = getSecondFlavourIfPresent(dto);

        return IceCream.builder()
                .iceCreamId(dto.getIceCreamId())
                .dressing(dto.getDressing())
                .sauce(dto.getSauce())
                .firstFlavour(dto.getFlavours().get(0))
                .secondFlavour(secondFlavour)
                .build();
    }

    public IceCream updateEntity(IceCream iceCream, IceCreamDto dto){

        iceCream.setDressing(dto.getDressing());
        iceCream.setSauce(dto.getSauce());
        iceCream.setFirstFlavour(dto.getFlavours().get(0));

        String secondFlavour = getSecondFlavourIfPresent(dto);
        if(Objects.nonNull(secondFlavour) && !secondFlavour.isEmpty()){
            iceCream.setSecondFlavour(secondFlavour);
        }

        return iceCream;
    }

    private String getSecondFlavourIfPresent(IceCreamDto dto){

        String secondFlavour = "";
        List<String> flavours = dto.getFlavours();

        if (Objects.nonNull(flavours)){
            if(flavours.size() > 1){
                secondFlavour = flavours.get(1);
            }
        }
        return secondFlavour;
    }
}
