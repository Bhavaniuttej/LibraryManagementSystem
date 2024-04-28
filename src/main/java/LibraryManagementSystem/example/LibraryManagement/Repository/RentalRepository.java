package LibraryManagementSystem.example.LibraryManagement.Repository;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import LibraryManagementSystem.example.LibraryManagement.Entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
//    List<Rental> findByRenterName(String renterName);
//
//    List<Rental> findByReturnDateIsNull(LocalDate overDueDate);
//
//    List<Rental> findByReturnDateAfter(LocalDate date);

//    List<Rental> findByBookIdAndReturnDateIsNull(Long bookId);

    @Query("SELECT r FROM Rental r WHERE r.bookId.id = :bookId AND r.returnDate IS NULL")
    boolean existsByBookId_IdAndReturnDateIsNull(Long bookId);

//    List<Rental> findByReturnDateIsNullAndRentalDateBefore(LocalDate overDueDate);
}
