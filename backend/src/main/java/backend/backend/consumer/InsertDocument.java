package backend.backend.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import backend.backend.documents.BookDocument;
import backend.backend.entities.Book;
import backend.backend.events.BookEvent;
import backend.backend.repositories.elastic.BookElasticRepo;

@Service
public class InsertDocument {
    @Autowired
    private BookElasticRepo elasticRepo;

    @KafkaListener(
        topics = "books-topic",
        groupId = "book-group"
    )
    public void consume(BookEvent event){
        BookDocument bookDocument = BookDocument.builder()
        .title(event.getTitle())
        .author(event.getAuthor())
        .description(event.getDescription())
        .build();
        elasticRepo.save(bookDocument);
        System.out.println("Titre is :"+event.getTitle());
    }
}
