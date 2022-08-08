package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
