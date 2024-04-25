package LibraryManagementSystem.example.LibraryManagement.Service;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookId(Long id);

    Book saveBook (Book book);

    void deleteBook(Long id);

    List<Book> getBooksByAuthor(String Author);
}
