package backend.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.backend.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{
    
}
