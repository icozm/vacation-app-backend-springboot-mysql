package com.example.ivan.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id", nullable = false)
    private Long id;

    @Column(name="address")
    private String address;

    @Column(name="create_date", nullable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name="customer_first_name", nullable = false)
    private String firstName;

    @Column(name="customer_last_name")
    private String lastName;

    @Column(name="last_update", nullable = false)
    @UpdateTimestamp
    private Date last_update;

    @Column(name="phone")
    private String phone;

    @Column(name="postal_code")
    private String postal_code;

    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;

    public void add(Cart cart) {
    }
}
