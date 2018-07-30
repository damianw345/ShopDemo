package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Food;
import com.github.damianw345.shopdemo.dto.FoodDto;
import com.github.damianw345.shopdemo.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FoodService {


    private final FoodRepository foodRepository;


    public Page<FoodDto> getFoods(Pageable pageable) {
        return null;

    }

    public FoodDto addFood(FoodDto dto) {

        Food food = new Food(dto.getFoodId(), dto.getName(), dto.getPrice(), "", null);
        foodRepository.save(food);
        return new FoodDto(food.getFoodId(), food.getName(), null, food.getPrice());

    }

    public FoodDto getFood(String id) {
        Food food = foodRepository.findAll().get(0);

        return new FoodDto(food.getFoodId(), food.getName(), null, food.getPrice());


    }

    public FoodDto updateFood(FoodDto dto, String id) {
        return null;

    }

    public void deleteFood(String id) {
    }
}
