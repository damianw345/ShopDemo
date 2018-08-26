package com.github.damianw345.shopdemo.controller;

import com.github.damianw345.shopdemo.dto.DressingDto;
import com.github.damianw345.shopdemo.dto.ResponseDto;
import com.github.damianw345.shopdemo.service.DressingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/dressings")
public class DressingController {

    private final DressingService dressingService;

    @RequestMapping(method = RequestMethod.GET)
    List<ResponseDto> getDressings() {
        return dressingService.getDressings();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ResponseDto addDressing(@RequestBody DressingDto dto) {
        return dressingService.addDressing(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseDto getDressing(@PathVariable Long id) {
        return dressingService.getDressing(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteDressing(@PathVariable Long id) {
        dressingService.deleteDressing(id);
    }
}
