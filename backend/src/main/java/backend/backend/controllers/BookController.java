package backend.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.backend.dto.BookDTO;
import backend.backend.services.database.BookService;
import backend.backend.services.elasticsearch.BookDocumentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookDocumentService bookDocumentService;


    @PostMapping("/add/book")
    public ResponseEntity<?> addBook(@RequestBody BookDTO entity) {
        return bookService.addBook(entity);
    }   

    @GetMapping("/search")
    public ResponseEntity<?> getMethodName(@RequestParam String keyword) {
        return bookDocumentService.searchByField(keyword);
        //return ResponseEntity.ok(keyword);
    }
    
    
    
}
