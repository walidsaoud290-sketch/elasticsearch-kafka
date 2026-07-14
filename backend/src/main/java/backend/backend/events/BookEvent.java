package backend.backend.events;

import backend.backend.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor 
@Data 
@Builder
public class BookEvent {

    private Long id;
    private String title;
    private String author;
    private String description;

}
