package com.github.damianw345.shopdemo.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "iceCreams_to_orders")
public class IceCreamsToOrders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iceCream_order_id")
    private Long iceCreamOrderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iceCream_id")
    private IceCream iceCream;

    @Column
    private Integer iceCreamAmount;
}
