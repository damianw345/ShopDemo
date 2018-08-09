package com.github.damianw345.shopdemo.controller;

import com.github.damianw345.shopdemo.dto.OrderDto;
import com.github.damianw345.shopdemo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/orders")
public class OrderController
{
    private final OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    List<OrderDto> getOrders(@RequestParam(value = "filter", required = false, defaultValue = "all") String finished) {
        return orderService.getOrders(finished);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    OrderDto addOrder(@RequestBody OrderDto dto) {
        return orderService.addOrder(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    OrderDto getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    OrderDto updateOrder(@RequestBody OrderDto dto, @PathVariable Long id) {
        return orderService.updateOrder(dto, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
