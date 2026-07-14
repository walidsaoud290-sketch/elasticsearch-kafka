package backend.backend.documents;


import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName = "books")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class BookDocument {
    @Id
    private String id;
    // pour l'autocomplete
    @Field(type = FieldType.Search_As_You_Type)
    private String title;
    @Field(type = FieldType.Text)
    private String author;
    @Field(type = FieldType.Text)
    private String description;
}
