package com.NimapTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapTask.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

