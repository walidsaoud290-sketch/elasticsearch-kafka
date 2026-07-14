package backend.backend.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import backend.backend.events.BookEvent;

@Service
public class BookProducer {
    private final KafkaTemplate<String,BookEvent> kafkaTemplate;

    public BookProducer(KafkaTemplate<String, BookEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(BookEvent event){
        kafkaTemplate.send("books-topic",event);
    }

    
}
