package com.example.ivan.services;

import com.example.ivan.entities.Cart;
import com.example.ivan.entities.CartItem;
import com.example.ivan.entities.Customer;
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
