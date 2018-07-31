package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dto.BasicFoodDto;
import com.github.damianw345.shopdemo.dto.FoodDto;
import com.github.damianw345.shopdemo.mapper.FoodMapper;
import com.github.damianw345.shopdemo.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FoodService {


    private final FoodRepository foodRepository;
    private final FoodMapper foodMapper;

    public List<BasicFoodDto> getAllFoods() {

        return Optional.ofNullable(foodRepository.findAll())
                .map(foodMapper::toDtoList)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public BasicFoodDto addFood(FoodDto dto) {

        return Optional.ofNullable(dto)
                .map(foodMapper::toEntity)
                .map(foodRepository::save)
                .map(foodMapper::toBasicDto)
                .orElseThrow(BadRequestException::new);
    }

    public BasicFoodDto getFood(Long id) {

        return Optional.ofNullable(foodRepository.getOne(id))
                .map(foodMapper::toBasicDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public BasicFoodDto updateFood(FoodDto dto, Long id) {

        return Optional.ofNullable(foodRepository.getOne(id))
                .map(food -> foodMapper.updateEntity(food, dto))
                .map(foodRepository::save)
                .map(foodMapper::toBasicDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
