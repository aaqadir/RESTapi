package com.restapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    @Autowired
    BookService bookService;
    @Test
    void getBookList() {
        bookService.getBookList();
    }
}