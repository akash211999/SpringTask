package com.NimapTask.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NimapTask.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

