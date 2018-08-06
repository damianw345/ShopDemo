package com.github.damianw345.shopdemo.repository;

import com.github.damianw345.shopdemo.entity.IceCream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IceCreamRepository extends JpaRepository<IceCream, Long> {

    List<IceCream> findAllByOrder_OrderId(Long orderId);
}
