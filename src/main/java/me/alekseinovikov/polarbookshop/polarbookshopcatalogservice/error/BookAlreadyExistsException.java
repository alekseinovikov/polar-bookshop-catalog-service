package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.error;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN " + isbn + " already exists.");
    }
}