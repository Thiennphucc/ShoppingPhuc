package com.shopPhuc.ShoppingOnline.repository;


import com.shopPhuc.ShoppingOnline.model.category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<category, Long> {
    Optional<category> findById(Long id);
}
