package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/my-bookings")
public class BookingHistoryController {

    @GetMapping
    public ResponseEntity<List<Booking>> getMyBookings() {
        // Логика получения истории бронирования
        return ResponseEntity.ok(List.of(new Booking()));
    }
}