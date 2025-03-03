package dashbah.wishlistapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/{username}/gifts")
public class BookingController {

    @PostMapping("/book/{id}")
    public ResponseEntity<String> bookGift(@PathVariable String username, @PathVariable Long id) {
        // Логика бронирования подарка
        return ResponseEntity.ok("Gift booked");
    }

    @PostMapping("/cancel-booking/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable String username, @PathVariable Long id) {
        // Логика отмены бронирования
        return ResponseEntity.ok("Booking canceled");
    }
}