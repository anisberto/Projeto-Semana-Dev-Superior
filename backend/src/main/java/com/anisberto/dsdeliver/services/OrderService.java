package com.anisberto.dsdeliver.services;

import com.anisberto.dsdeliver.dto.OrderDTO;
import com.anisberto.dsdeliver.entities.Order;
import com.anisberto.dsdeliver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = orderRepository.findOrderWithProducts();
        return list.stream().map(orderIntListDTO -> new OrderDTO(orderIntListDTO)).collect(Collectors.toList());
    }
}
