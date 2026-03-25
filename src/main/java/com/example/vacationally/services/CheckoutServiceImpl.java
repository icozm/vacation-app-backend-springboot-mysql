package com.example.vacationally.services;

import com.example.vacationally.dao.*;
import com.example.vacationally.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private VacationRepository vacationRepository;
    private ExcursionRepository excursionRepository;



    public CheckoutServiceImpl(CustomerRepository customerRepository,
                               CartRepository cartRepository,
                               CartItemRepository cartItemRepository,
                               VacationRepository vacationRepository,
                               ExcursionRepository excursionRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.vacationRepository = vacationRepository;
        this.excursionRepository = excursionRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // Generate order tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        purchase.getCart().setOrderTrackingNumber(orderTrackingNumber);
        purchase.getCart().setStatus(StatusType.ordered);

        // Fetch the vacation

        Vacation vacation = purchase.getCartItems()
                .stream()
                .findFirst()
                .map(CartItem::getVacation)
                .orElseThrow(() -> new IllegalArgumentException("Vacation cannot be null."));

        vacationRepository.save(vacation);

        Cart savedCart = cartRepository.save(purchase.getCart());

        //Save the cart item
        purchase.getCartItems().forEach(cartItem -> {
            cartItem.setCart(savedCart);
            cartItemRepository.save(cartItem);
        });

        purchase.getCartItems().forEach(cartItem -> {
            Set<Excursion> excursionsForCartItem = cartItem.getExcursions();
            if (excursionsForCartItem != null) {
                excursionsForCartItem.forEach(excursion -> {
                    Excursion persistedExcursion = excursionRepository.findById(excursion.getId()).orElse(null);
                    if (persistedExcursion != null){
                        persistedExcursion.getCart_items().add(cartItem);
                        excursionRepository.save(persistedExcursion);
                    }
                });
            }
        });

        // Save the customer

        Customer customer = purchase.getCustomer();
        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUIS number v4
        return UUID.randomUUID().toString();
    }
}



