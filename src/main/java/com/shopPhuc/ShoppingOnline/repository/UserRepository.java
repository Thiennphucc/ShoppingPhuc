package com.shopPhuc.ShoppingOnline.repository;

import com.shopPhuc.ShoppingOnline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByUsername(String username);
}
