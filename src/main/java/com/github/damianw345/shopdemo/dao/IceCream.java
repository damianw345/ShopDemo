package com.github.damianw345.shopdemo.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "iceCreams")
public class IceCream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iceCream_id")
    private Long iceCreamId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String price;

    @Column
    private String imagePath;

    @OneToMany(mappedBy = "iceCream", cascade = CascadeType.ALL)
    private Set<IceCreamsToOrders> iceCreamsToOrders;
}
