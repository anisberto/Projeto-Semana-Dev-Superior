package com.anisberto.dsdeliver.controllers;

import com.anisberto.dsdeliver.dto.OrderDTO;
import com.anisberto.dsdeliver.dto.ProductDTO;
import com.anisberto.dsdeliver.entities.Order;
import com.anisberto.dsdeliver.services.OrderService;
import com.anisberto.dsdeliver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO order){
        order = orderService.insert(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> put(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.setDelivered(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id)) ;
    }
}