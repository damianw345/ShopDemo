//package com.github.damianw345.shopdemo.controller;
//
//import com.github.damianw345.shopdemo.dto.IceCreamDto;
//import com.github.damianw345.shopdemo.service.IceCreamService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@RequestMapping("/iceCreams")
//public class IceCreamController {
//
//    private final IceCreamService iceCreamService;
//
//    @RequestMapping(method = RequestMethod.GET)
//    List<BasicIceCreamDto> getIceCreams() { return iceCreamService.getAllIceCreams();}
//
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    BasicIceCreamDto addIceCream(@RequestBody IceCreamDto dto) {
//        return iceCreamService.addIceCream(dto);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    BasicIceCreamDto getIceCream(@PathVariable Long id) {
//        return iceCreamService.getIceCream(id);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//    BasicIceCreamDto updateIceCream(@RequestBody IceCreamDto dto, @PathVariable Long id) {
//        return iceCreamService.updateIceCream(dto, id);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void deleteIceCream(@PathVariable Long id) {
//        iceCreamService.deleteIceCream(id);
//    }
//}
