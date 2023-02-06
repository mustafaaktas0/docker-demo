package com.mustafa.bookstoredemo.repository;

import com.mustafa.bookstoredemo.model.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderBook, Integer> {
}
