package com.example.vacationally.services;

import com.example.vacationally.entities.Cart;
import com.example.vacationally.entities.CartItem;
import com.example.vacationally.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class Purchase {
    Customer customer;
    Cart cart;
    Set<CartItem> cartItems;
}
