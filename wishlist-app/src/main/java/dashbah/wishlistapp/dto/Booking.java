package dashbah.wishlistapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Booking {
    private Long bookingId;
    private Timestamp bookedAt;
    private String status;
}
