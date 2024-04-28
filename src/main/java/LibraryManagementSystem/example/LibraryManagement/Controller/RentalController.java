package LibraryManagementSystem.example.LibraryManagement.Controller;

import LibraryManagementSystem.example.LibraryManagement.Entity.Rental;
import LibraryManagementSystem.example.LibraryManagement.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/rent")
    public ResponseEntity<String> rentBook(@RequestBody Rental rental){
        int rentalId = rentalService.rentBook(rental);
        if(rentalId == -1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The book is already Rented");
        }

        return ResponseEntity.ok("Created a new rental for the specified book "+ rentalId + " created new book");
    }

    @PostMapping("/return/{rentalId}")
    public ResponseEntity<String> returnedBook(@PathVariable Long rentalId){
        Rental returnRental = rentalService.returnBook(rentalId);
        if(returnRental == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("the book is Returned" + returnRental);
    }

    @GetMapping("check/{bookId}")
    public ResponseEntity<Boolean> isBookAlreadyRented(@PathVariable Long bookId){
        boolean isRented = rentalService.isBookAlreadyRented(bookId);
        return ResponseEntity.ok(isRented);
    }
}
