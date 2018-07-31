package com.github.damianw345.shopdemo.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    @Column
    private String imagePath;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private Set<FoodsToOrders> foodsToOrders;
}
