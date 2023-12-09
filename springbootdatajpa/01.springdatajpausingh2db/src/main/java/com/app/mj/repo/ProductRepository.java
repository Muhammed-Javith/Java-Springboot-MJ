package com.app.mj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.mj.model.Product;

@Repository // Optional
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
