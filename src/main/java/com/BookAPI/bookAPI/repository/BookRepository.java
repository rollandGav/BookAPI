package com.BookAPI.bookAPI.repository;

import com.BookAPI.bookAPI.model.Book;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<String, Book> books = new HashMap<>();

    public List<Book> findAll(){
        return new ArrayList<>(books.values());
    }

    public Book findByTitle(String title){
        return books.get(title);
    }

    public Book save(Book book){
        books.put(book.getTitle(), book);
        return book;
    }

    public void delete(String title){
        books.remove(title);
    }

    @PostConstruct
    public void init(){
        System.out.println("BookRepository initialized");
    }

    @PreDestroy
    public void shutdown(){
        System.out.println("BookRepository is being destroyed");
    }

}
