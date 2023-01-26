package me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.demo;

import lombok.RequiredArgsConstructor;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.domain.Book;
import me.alekseinovikov.polarbookshop.polarbookshopcatalogservice.repository.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository bookRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = new Book("978-3-16-148410-0", "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979.0);
        var book2 = new Book("978-3-16-148410-1", "The Restaurant at the End of the Universe", "Douglas Adams", 1980.0);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }

}
