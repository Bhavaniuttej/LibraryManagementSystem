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
@Table(name = "Rental")
public class Rental {
    @Id
    @Column()
    private int id;
    @Column(name = "bookId")
    private int bookId;
    @Column(name = "renterName")
    private String renterName;
    @Column(name = "rentalDate")
    private String rentalDate;
    private Date returnDate;
}
