package LibraryManagementSystem.example.LibraryManagement.Repository;

import LibraryManagementSystem.example.LibraryManagement.Entity.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Long> {
}
