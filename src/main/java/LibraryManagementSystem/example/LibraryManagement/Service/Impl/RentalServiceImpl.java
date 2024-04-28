package LibraryManagementSystem.example.LibraryManagement.Service.Impl;

import LibraryManagementSystem.example.LibraryManagement.Entity.Book;
import LibraryManagementSystem.example.LibraryManagement.Entity.Rental;
import LibraryManagementSystem.example.LibraryManagement.Repository.BookRepository;
import LibraryManagementSystem.example.LibraryManagement.Repository.RentalRepository;
import LibraryManagementSystem.example.LibraryManagement.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public int rentBook(Rental rental) {
        if(isBookAlreadyRented(Long.valueOf((Integer)rental.getBookId().getId()))){
            return -1;
        }
        rental.setRentalDate(LocalDate.now());
        rental.setReturnDate(LocalDate.now().plusDays(14));

        Rental saveRental =  rentalRepository.save(rental);
        return saveRental.getId();
    }

    @Override
    public Rental returnBook(Long rentalId) {
        Rental rental = rentalRepository.findById(rentalId).orElse(null);
        if(rental == null || rental.getReturnDate() != null){
            return null;
        }

        rental.setReturnDate(LocalDate.now());
        return rentalRepository.save(rental);
    }

    @Override
    public boolean isBookAlreadyRented(Long bookId) {
        return rentalRepository.existsByBookId_IdAndReturnDateIsNull(bookId);
    }

}
