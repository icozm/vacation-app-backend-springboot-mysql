package com.example.vacationally.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="divisions")
@Setter
@Getter
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name="division")
    private String division_name;

    @Column(name="create_date")
    @CreationTimestamp
    private Date crete_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    // Relationship to Country
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customers;

    @Column(name="country_id")
    private Long country_id;
    public void setCountery(Country country){
        setCountry_id(country.getId());
        this.country = country;
    }

}
