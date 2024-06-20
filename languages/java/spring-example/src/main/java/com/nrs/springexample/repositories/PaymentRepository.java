package com.nrs.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrs.springexample.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
