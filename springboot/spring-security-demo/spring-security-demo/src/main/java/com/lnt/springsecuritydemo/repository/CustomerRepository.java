package com.lnt.springsecuritydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.springsecuritydemo.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    List<Customer> findByEmail(String email);
}
