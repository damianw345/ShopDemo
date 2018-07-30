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
@Entity(name = "foods_to_orders")
public class FoodsToOrders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "food_order_id")
    private Long foodOrderId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "food_id")
    private Food food;

    @Column
    private Integer foodAmount;
}
