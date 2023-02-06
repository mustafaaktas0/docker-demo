package com.mustafa.bookstoredemo;

import com.mustafa.bookstoredemo.model.Book;
import com.mustafa.bookstoredemo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreDemoApplication implements CommandLineRunner {

    private final BookRepository bookRepository;

    public BookStoreDemoApplication(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreDemoApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book.builder()
                .name("Yuzuklerin Efendisi")
                .author("J.R.R. Tolkien")
                .price(10.0)
                .stock(10)
                .build();

        Book book2 = Book.builder()
                .name("Yuzuklerin Efendisi-2")
                .author("J.R.R. Tolkien")
                .price(10.0)
                .stock(10)
                .build();

        Book book3 = Book.builder()
                .name("Yuzuklerin Efendisi-3")
                .author("J.R.R. Tolkien")
                .price(10.0)
                .stock(10)
                .build();


        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

    }
}
