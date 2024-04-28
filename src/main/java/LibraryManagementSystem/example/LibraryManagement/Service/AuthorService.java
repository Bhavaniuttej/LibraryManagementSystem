package LibraryManagementSystem.example.LibraryManagement.Service;

import LibraryManagementSystem.example.LibraryManagement.Entity.Author;
import LibraryManagementSystem.example.LibraryManagement.Entity.Book;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthors();

    Author getAuthorId(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);
}
