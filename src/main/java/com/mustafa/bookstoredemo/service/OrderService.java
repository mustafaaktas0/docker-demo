package com.mustafa.bookstoredemo.service;

import com.mustafa.bookstoredemo.model.Book;
import com.mustafa.bookstoredemo.model.OrderBook;
import com.mustafa.bookstoredemo.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final BookService bookService;
    private final OrderRepository orderRepository;

    public OrderService(BookService bookService, OrderRepository orderRepository) {
        this.bookService = bookService;
        this.orderRepository = orderRepository;
    }

    public OrderBook putAnOrder(List<Integer> bookIdList, String userName) {
        List<Optional<Book>> bookList = bookIdList.stream()
                .map(bookService::findBookById).collect(Collectors.toList());

        Double totalPrice = bookList.stream()
                .map(optionalBook ->
                        optionalBook.map(Book::getPrice)
                                .orElse(0.0))
                .reduce(0.0, Double::sum);

        OrderBook order = OrderBook.builder()
                .bookList(bookIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();

        return orderRepository.save(order);
    }

    public List<OrderBook> getAllOrderBooks() {
        return orderRepository.findAll();
    }
}
