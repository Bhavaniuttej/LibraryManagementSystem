package LibraryManagementSystem.example.LibraryManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(name = "author")
    private Author author;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publication_year")
    private Date publicationYear;
}
