package com.shutterstore.controller;

import com.shutterstore.dto.Orderresponsedto;
import com.shutterstore.services.Orderservice;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Orders")
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("/orders")
public class Ordercontroller {

    @Autowired
    private Orderservice orderservice;


    @PostMapping("/create")
    public Orderresponsedto createOrder(@RequestParam Long userId, @RequestParam String shippingAddress) {

        return orderservice.createorder(userId, shippingAddress);
    }


    @GetMapping("/details/{orderId}")
    public Orderresponsedto getOrderDetails(@PathVariable Long orderId) {

        return orderservice.orderdetails(orderId);
    }


    @GetMapping("/user/{userId}")
    public List<Orderresponsedto> getUserOrders(@PathVariable Long userId) {

        return orderservice.userordershistory(userId);
    }


    @PutMapping("/status/{orderId}")
    public Orderresponsedto updateOrderStatus(@PathVariable Long orderId, @RequestParam String status) {

        return orderservice.updatestatusorder(orderId, status);
    }


    @PutMapping("/cancel/{orderId}")
    public Orderresponsedto cancelOrder(@PathVariable Long orderId) {

        return orderservice.cancelorder(orderId);
    }
}
