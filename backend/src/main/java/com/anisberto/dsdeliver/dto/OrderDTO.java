package com.anisberto.dsdeliver.dto;

import com.anisberto.dsdeliver.enumerations.OrderStatus;

import java.io.Serializable;
import java.time.Instant;

public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private  String address;
    private double latitude;
    private double longitude;
    private Instant moment;
    private OrderStatus status;
}
