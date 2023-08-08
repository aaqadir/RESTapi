package com.restapi.dao;

import com.restapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findById(int bId);
    @Query(value = "select * from books where book_id=?1 and book_title=?2",nativeQuery = true)
    public Book getByIdAndTitle(int bId,String bTitle);
    @Query(value = "select * from books where book_id between ?1 and ?2",nativeQuery = true)
    public List<Book> getInRange(int start,int end);
}
