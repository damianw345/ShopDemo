package com.github.damianw345.shopdemo.controller;

import com.github.damianw345.shopdemo.dto.FoodDto;
import com.github.damianw345.shopdemo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;

    @RequestMapping(method = RequestMethod.GET)
    List<FoodDto> getFoods() { return foodService.getAllFoods();}

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    FoodDto addFood(@RequestBody FoodDto dto) {
        return foodService.addFood(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    FoodDto getFood(@PathVariable Long id) {
        return foodService.getFood(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    FoodDto updateFood(@RequestBody FoodDto dto, @PathVariable Long id) {
        return foodService.updateFood(dto, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
    }
}
