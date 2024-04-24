package LibraryManagementSystem.example.LibraryManagement.Repository;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
}
