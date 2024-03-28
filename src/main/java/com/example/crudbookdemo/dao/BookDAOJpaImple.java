package com.example.crudbookdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.crudbookdemo.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class BookDAOJpaImple implements BookDAO {

    private EntityManager entityManager;

    @Autowired
    public BookDAOJpaImple(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> bookQuery = entityManager.createQuery("from Book", Book.class);
        return bookQuery.getResultList();
    }

    @Override
    public Book findById(int id) {
        Book bookToFind = entityManager.find(Book.class, id);
        return bookToFind;
    }

    @Override
    public Book save(Book theBook) {
        Book updatedBook = entityManager.merge(theBook);
        return updatedBook;
    }

    @Override
    public void deleteById(int id) {
        Book bookToRemove = entityManager.find(Book.class, id);
        entityManager.remove(bookToRemove);
        return;
    }
}
