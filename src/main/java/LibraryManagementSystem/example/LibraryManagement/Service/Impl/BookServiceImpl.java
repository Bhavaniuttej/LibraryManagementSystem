package LibraryManagementSystem.example.LibraryManagement.Service.Impl;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import LibraryManagementSystem.example.LibraryManagement.Repository.BookRepository;
import LibraryManagementSystem.example.LibraryManagement.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Book getBookId(Long id) {
        Book book = new Book();
        if(book == null){
            System.out.println("Book Not Found");
        }
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        if(book != null || book == null){
            book.setId(book.getId());
            book.setTitle(book.getTitle());
            book.setIsbn(book.getIsbn());
            book.setPublicationYear(book.getPublicationYear());
        }

        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> getBooksByAuthor(String Author) {
        return null;
    }
}
