package LibraryManagementSystem.example.LibraryManagement.Entity;


import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;


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

//     @Column(name = "author")
//     private Author author;


    @Column(name = "internation_standard_book_number")
    private String isbn_book;

    @Column(name = "publication_year")
    private Date publicationYear;



}
