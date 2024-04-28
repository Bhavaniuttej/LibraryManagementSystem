package LibraryManagementSystem.example.LibraryManagement.Controller;

import LibraryManagementSystem.example.LibraryManagement.Entity.Author;
import LibraryManagementSystem.example.LibraryManagement.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthController {

    @Autowired
    private AuthorService authorService;


    @PostMapping("/new_author")
    public ResponseEntity<String> createAuthor(@RequestBody Author author){
        try{
            authorService.saveAuthor(author);
            return ResponseEntity.ok("Created new Author Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorDetails(@PathVariable Long id, @RequestBody Author authorDetails){
        try{
            Author author = authorService.getAuthorId(id);

            if(author == null){
                throw new RuntimeException("Id with Author not Found");
            }

            author.setId(author.getId());
            author.setName(author.getName());
            author.setBiography(author.getBiography());

            authorService.saveAuthor(author);

            return ResponseEntity.ok("Updated Author Details Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorDetails(@PathVariable Long id){
        Author author= authorService.getAuthorId(id);
        if(author == null){
            return ResponseEntity.notFound().build();
        }

        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Author details deleted Successfully");
    }
}
