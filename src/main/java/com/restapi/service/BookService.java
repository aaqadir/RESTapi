package com.restapi.service;

import com.restapi.dao.BookRepository;
import com.restapi.entity.Book;
import com.restapi.query.QueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    EntityManager entityManager;

    /* private static List<Book> bookList = new ArrayList<>();
     static {
         bookList.add(new Book(1,"Book One","bnm"));
         bookList.add(new Book(2,"Spring","xyz"));
         bookList.add(new Book(3,"Spring Core","qwe"));
         bookList.add(new Book(4,"Spring mvc","poi"));
         bookList.add(new Book(5,"Spring orm","fgh"));
     }*/
    public List<Book> getBookList() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }


    public Book getBookById(int bId) {
        return bookRepository.findById(bId);
    }

    public Book addBook(Book b) {
        Book save = bookRepository.save(b);
        return save;
    }

    public void deleteBook(int bId) {
        bookRepository.deleteById(bId);
    }

    public void updateBook(Book book, int bookId) {
        if (bookId==book.getId()){
        bookRepository.save(book);}
    }
    public Book getByIdTitle(int id, String title){
        return bookRepository.getByIdAndTitle(id, title);
    }
    public List getByRange(int sId, int eId){
        return bookRepository.getInRange(sId,eId);
        /*QueryUtil q = new QueryUtil();
        Query query = entityManager.createNativeQuery(q.rangeQuery(sId, eId));
        return query.getResultList();*/
    }
}
