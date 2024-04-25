package LibraryManagementSystem.example.LibraryManagement.Controller;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import LibraryManagementSystem.example.LibraryManagement.Service.BookService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/new_book")
    public ResponseEntity<String> createBook(@RequestBody Book book){
        try{
            bookService.saveBook(book);
            return ResponseEntity.ok("Created new Book Successfully");

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateBookDetails(@PathVariable Long id, @RequestBody Book bookDetails){
        try{
            Book book = bookService.getBookId(id);
            if (book == null) {
                throw new RuntimeException("Id with Book not Found");
            }
            book.setTitle(book.getTitle());
            book.setIsbn(book.getIsbn());
            book.setPublicationYear(book.getPublicationYear());

            bookService.saveBook(book);
            return ResponseEntity.ok("Updated Details Book Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookDetails(@PathVariable Long id){
        Book book = bookService.getBookId(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBook(id);
        return ResponseEntity.ok("Deleted Book Successfully");

    }



}
