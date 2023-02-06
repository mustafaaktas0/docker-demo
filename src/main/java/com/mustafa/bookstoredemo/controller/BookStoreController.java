package com.mustafa.bookstoredemo.controller;

import com.mustafa.bookstoredemo.dto.BookOrderRequest;
import com.mustafa.bookstoredemo.model.Book;
import com.mustafa.bookstoredemo.model.OrderBook;
import com.mustafa.bookstoredemo.service.BookService;
import com.mustafa.bookstoredemo.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/bookStore")
public class BookStoreController {

    private final OrderService orderService;
    private final BookService bookService;

    public BookStoreController(OrderService orderService, BookService bookService) {
        this.orderService = orderService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderBook>> getAllOrderBooks() {
        return ResponseEntity.ok(orderService.getAllOrderBooks());
    }

    @PostMapping()
    public ResponseEntity<OrderBook> putAnOrder(@RequestBody BookOrderRequest bookOrderRequest) {
        OrderBook order = orderService.putAnOrder(bookOrderRequest.getBookIdList(), bookOrderRequest.getUserName());
        return ResponseEntity.ok(order);
    }
}
