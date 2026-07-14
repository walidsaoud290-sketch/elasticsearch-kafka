package backend.backend.services.database;

import java.net.ResponseCache;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import backend.backend.dto.BookDTO;
import backend.backend.entities.Book;
import backend.backend.events.BookEvent;
import backend.backend.producer.BookProducer;
import backend.backend.repositories.BookRepository;

@Service
public class BookService {
    private BookProducer producer;
    private BookRepository bookRepository;   


    public BookService(BookProducer producer, BookRepository bookRepository) {
        this.producer = producer;
        this.bookRepository = bookRepository;
    }


    public ResponseEntity<?> addBook(BookDTO bookDTO){
        Book book = Book.builder()
        .title(bookDTO.getTitle())
        .author(bookDTO.getAuthor())
        .description(bookDTO.getDescrition())
        .build();
        BookEvent event = BookEvent.builder()
        .title(bookDTO.getTitle())
        .author(bookDTO.getAuthor())
        .description(bookDTO.getDescrition())
        .build();
        bookRepository.save(book);
        producer.publish(event);
        return ResponseEntity.status(org.springframework.http.HttpStatus.CREATED).body("INSERTION SUCCESSFULY");
    }
}
