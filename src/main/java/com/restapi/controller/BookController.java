package com.restapi.controller;

import com.restapi.entity.Book;
import com.restapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> bookList = bookService.getBookList();
        if (bookList.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id){
        Book bookById = bookService.getBookById(id);
        if (bookById==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(bookById);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book addBook = null;
        try {
            addBook = bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(addBook);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
    }
    @DeleteMapping("/books/{bId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bId){
        try {
            bookService.deleteBook(bId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Void> updateBook(@RequestBody Book book,@PathVariable int bookId){
        try {
            bookService.updateBook(book, bookId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/books/{id}/{author}")
    public ResponseEntity<Book> getBook(@PathVariable int id, @PathVariable String author){
        Book bookById = bookService.getByIdTitle(id,author);
        if (bookById==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(bookById));
    }

    @GetMapping("/books/r/{sId}/{eId}")
    public ResponseEntity<List> getBookByRange(@PathVariable int sId, @PathVariable int eId){
        List books = bookService.getByRange(sId,eId);
        if (books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(books));
    }
}
