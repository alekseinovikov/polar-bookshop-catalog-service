package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.domain;

public record Book(
        String isbn,
        String title,
        String author,
        Double price
) {
}
