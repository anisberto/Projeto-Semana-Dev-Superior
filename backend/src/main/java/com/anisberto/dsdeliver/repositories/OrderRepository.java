package com.anisberto.dsdeliver.repositories;

import com.anisberto.dsdeliver.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}