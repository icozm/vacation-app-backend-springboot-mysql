package com.example.ivan.dao;

import com.example.ivan.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
