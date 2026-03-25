package com.example.vacationally.bootstrap;

import com.example.vacationally.dao.CustomerRepository;
import com.example.vacationally.dao.DivisionRepository;
import com.example.vacationally.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }




    @Override
    public void run(String... args) throws Exception{

        Customer ivan = new Customer();
        ivan.setFirstName("Ivan");
        ivan.setLastName("Cozmo");
        ivan.setAddress("123 Lane Avenue");
        ivan.setPostal_code("22558");
        ivan.setPhone("9876652258");

        Customer dan = new Customer();
        dan.setFirstName("Dan");
        dan.setLastName("Balan");
        dan.setAddress("777 Balash Avenue");
        dan.setPostal_code("85452");
        dan.setPhone("9998885555");

        Customer orzo = new Customer();
        orzo.setFirstName("Orzo");
        orzo.setLastName("Pasta");
        orzo.setAddress("999 Erin Blvd");
        orzo.setPostal_code("98552");
        orzo.setPhone("9588228845");

        Customer iana = new Customer();
        iana.setFirstName("Iana");
        iana.setLastName("TheQueen");
        iana.setAddress("866 Britain Avenue");
        iana.setPostal_code("885225");
        iana.setPhone("9267782254");

        Customer sabrina = new Customer();
        sabrina.setFirstName("Sabrina");
        sabrina.setLastName("Smith");
        sabrina.setAddress("20 Mountain Avenue");
        sabrina.setPostal_code("752");
        sabrina.setPhone("85445852");

        customerRepository.save(ivan);
        customerRepository.save(dan);
        customerRepository.save(orzo);
        customerRepository.save(iana);
        customerRepository.save(sabrina);

    }
}