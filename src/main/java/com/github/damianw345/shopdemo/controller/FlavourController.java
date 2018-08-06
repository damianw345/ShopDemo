package com.github.damianw345.shopdemo.controller;

import com.github.damianw345.shopdemo.dao.Flavour;
import com.github.damianw345.shopdemo.service.FlavourService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/flavours")
public class FlavourController {

    private final FlavourService flavourService;

    @RequestMapping(method = RequestMethod.GET)
    List<Flavour> getFlavours() {
        return flavourService.getFlavours();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    Flavour addFlavour(@RequestBody Flavour dto) {
        return flavourService.addFlavour(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Flavour getFlavour(@PathVariable Long id) {
        return flavourService.getFlavour(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteFlavour(@PathVariable Long id) {
        flavourService.deleteFlavour(id);
    }
}
