package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.repository;

import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.domain.Book;

import java.util.Optional;

public interface BookRepository {
    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    Book save(Book book);

    void deleteByIsbn(String isbn);
}