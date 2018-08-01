package com.github.damianw345.shopdemo.dao;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity(name = "iceCreams")
public class IceCream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iceCream_id")
    private Long iceCreamId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "dressing")
    private String dressing;

    @Column(name = "first_flavour")
    private String firstFlavour;

    @Column(name = "second_flavour")
    private String secondFlavour;

    @Column(name = "sauce")
    private String sauce;
}
