package com.shopPhuc.ShoppingOnline.repository;


import com.shopPhuc.ShoppingOnline.model.product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<product, Long> {

    Page<product> findAllByTitle(String title,  Pageable pageable);
    Page<product> findByTitleContaining(String title, Pageable pageable);
    Optional<product> findById(Long id);
}
