package com.lnt.springsecuritydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lnt.springsecuritydemo.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
