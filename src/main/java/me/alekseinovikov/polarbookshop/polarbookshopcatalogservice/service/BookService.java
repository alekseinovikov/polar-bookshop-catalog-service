package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.service;

import lombok.RequiredArgsConstructor;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.domain.Book;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.error.BookAlreadyExistsException;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.error.BookNotFoundException;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) {
        if (bookRepository.existsByIsbn(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book) {
        return bookRepository.findByIsbn(isbn).map(existingBook -> {
            var bookToUpdate = new Book(
                    existingBook.isbn(), book.title(), book.author(), book.price());
            return bookRepository.save(bookToUpdate);
        }).orElseGet(() -> addBookToCatalog(book));
    }

}