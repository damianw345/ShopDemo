package com.github.damianw345.shopdemo.controller;

import com.github.damianw345.shopdemo.dao.Sauce;
import com.github.damianw345.shopdemo.service.SauceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/sauce")
public class SauceController {

    private final SauceService sauceService;

    @RequestMapping(method = RequestMethod.GET)
    List<Sauce> getSauces() {
        return sauceService.getSauces();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Sauce addSauce(@RequestBody Sauce dto) {
        return sauceService.addSauce(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Sauce getSauce(@PathVariable Long id) {
        return sauceService.getSauce(id);
    }

    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteSauce(@PathVariable Long id) {
        sauceService.deleteSauce(id);
    }
}
