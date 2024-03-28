package com.example.crudbookdemo.dao;

import java.util.List;

import com.example.crudbookdemo.entity.Book;

public interface BookDAO {
    List<Book> findAll();
    Book findById(int id);
    Book save(Book theBook);
    void deleteById(int id);
}
