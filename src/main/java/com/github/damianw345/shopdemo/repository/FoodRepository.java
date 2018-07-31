package com.github.damianw345.shopdemo.repository;

import com.github.damianw345.shopdemo.dao.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

}
