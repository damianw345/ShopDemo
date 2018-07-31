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
@Entity(name = "sauces")
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sauce_id")
    private Integer sauceId;

    @Column
    private String sauceName;
}
