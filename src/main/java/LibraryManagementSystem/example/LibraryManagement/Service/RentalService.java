package LibraryManagementSystem.example.LibraryManagement.Service;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import LibraryManagementSystem.example.LibraryManagement.Entity.Rental;

import java.util.List;

public interface RentalService {

    int rentBook(Rental rental);

    Rental returnBook(Long rentalId);

    boolean isBookAlreadyRented(Long bookId);
}
