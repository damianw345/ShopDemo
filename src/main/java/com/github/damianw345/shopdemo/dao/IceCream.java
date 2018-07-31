package com.github.damianw345.shopdemo.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "dressing_id")
    private Dressing dressing;

    @OneToMany
    @JoinColumn(name = "flavour_id")
    private Set<Flavour> flavours;

    @OneToOne
    @JoinColumn(name = "sauce_id")
    private Sauce sauce;

    @OneToMany(mappedBy = "iceCream", cascade = CascadeType.ALL)
    private Set<IceCreamsToOrders> iceCreamsToOrders;
}
