package LibraryManagementSystem.example.LibraryManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book bookId;
    @Column(name = "renterName")
    private String renterName;
    @Column(name = "rentalDate")
    private LocalDate rentalDate;
    @Column(name = "returnDate")
    private LocalDate returnDate;


//    public Long getBook() {
//        return
//    }
}
