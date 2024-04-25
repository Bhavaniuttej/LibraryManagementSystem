package LibraryManagementSystem.example.LibraryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "title")
    private String title;

//    @JoinColumn(name = "author")
//    private Author author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private Date publicationYear;
}
