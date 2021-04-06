package com.shop.orders.domain;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String departureCity;
    private String arrivedCity;
    private Date createdOrderTime;
    private Date departureTime;
    private Date arrivedTime;
    private Date closedOrderTime;
    private Long customerId;
    private Long supplierId;
    private Long productId;
}
