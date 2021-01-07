package com.anisberto.dsdeliver.services;

import com.anisberto.dsdeliver.dto.OrderDTO;
import com.anisberto.dsdeliver.dto.ProductDTO;
import com.anisberto.dsdeliver.entities.Order;
import com.anisberto.dsdeliver.enumerations.OrderStatus;
import com.anisberto.dsdeliver.repositories.OrderRepository;
import com.anisberto.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = orderRepository.findOrderWithProducts();
        return list.stream().map(orderIntListDTO -> new OrderDTO(orderIntListDTO)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null,dto.getAddress(),dto.getLatitude(),dto.getLongitude(), Instant.now(),
                OrderStatus.PENDING);
        for(ProductDTO productIn : dto.getProducts()){
            order.getProducts().add(productRepository.getOne(productIn.getId()));
        }
        order = orderRepository.save(order);
        return new OrderDTO(order);
    }
}
