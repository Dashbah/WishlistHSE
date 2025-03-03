package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.GiftDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ideas")
public class IdeasController {

    @GetMapping
    public ResponseEntity<List<GiftDTO>> getSampleGifts() {
        // Логика получения примеров подарков
        return ResponseEntity.ok(List.of(new GiftDTO()));
    }
}
