package LibraryManagementSystem.example.LibraryManagement.Service.Impl;

import LibraryManagementSystem.example.LibraryManagement.Entity.Author;
import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import LibraryManagementSystem.example.LibraryManagement.Repository.AuthorRepository;
import LibraryManagementSystem.example.LibraryManagement.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthorId(Long id) {
        Author author = new Author();
        if(author == null){
            System.out.println("Author Not Found");
        }
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author saveAuthor(Author author) {
        if(author != null){
            author.setId(author.getId());
            author.setName(author.getName());
            author.setBiography(author.getBiography());
        }
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()){
            Author au = author.get();
            authorRepository.delete(au);
        }
    }
}
