package com.anisberto.dsdeliver.controllers;

import com.anisberto.dsdeliver.dto.OrderDTO;
import com.anisberto.dsdeliver.dto.ProductDTO;
import com.anisberto.dsdeliver.services.OrderService;
import com.anisberto.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        return ResponseEntity.ok().body(orderService.findAll());
    }
}