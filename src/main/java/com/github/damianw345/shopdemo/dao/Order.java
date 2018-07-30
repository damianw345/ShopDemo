package com.github.damianw345.shopdemo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "foods_to_orders",
//            joinColumns = { @JoinColumn(name = "order_id") },
//            inverseJoinColumns = { @JoinColumn(name = "food_id") })
//    private Set<Food> foods;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<FoodsToOrders> foodsToOrders;

}
