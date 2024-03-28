package com.example.crudbookdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudbookdemo.dao.BookDAO;
import com.example.crudbookdemo.entity.Book;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImple implements BookService {

    private BookDAO bookDAO;

    @Autowired
    public BookServiceImple(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookDAO.findById(id);
    }

    @Override
    @Transactional
    public Book save(Book theBook) {
        return bookDAO.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        bookDAO.deleteById(id);
        return;
    }
}
