package com.github.damianw345.shopdemo.repository;

import com.github.damianw345.shopdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByIsFinished(Boolean isFinished);
}
