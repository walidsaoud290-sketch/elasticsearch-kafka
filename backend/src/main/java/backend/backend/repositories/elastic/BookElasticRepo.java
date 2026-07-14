package backend.backend.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import backend.backend.documents.BookDocument;

public interface BookElasticRepo extends ElasticsearchRepository<BookDocument,Long>{
    
}
