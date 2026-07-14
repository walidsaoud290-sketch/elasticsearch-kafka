package backend.backend.services.elasticsearch;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import backend.backend.documents.BookDocument;

@Service
public class BookDocumentService {
    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    // Search with prefix
    public ResponseEntity<?> searchByField(String keyword){
        NativeQuery query = NativeQuery.builder()
        .withQuery(q -> q.matchPhrasePrefix(p -> p.field("title").query(keyword)))
        .build();
        List<BookDocument> list = elasticsearchOperations.search(query,BookDocument.class).stream().map(SearchHit::getContent).toList();
        return ResponseEntity.status(200).body(list);
    }
}
