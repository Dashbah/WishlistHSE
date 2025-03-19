package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.GiftDTO;
import dashbah.wishlistapp.dto.request.PostGiftRq;
import dashbah.wishlistapp.exception.GiftNotFoundException;
import dashbah.wishlistapp.exception.UserNotFoundException;
import dashbah.wishlistapp.exception.WrongUserAndGiftPairException;
import dashbah.wishlistapp.service.GiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{username}/gifts")
@RequiredArgsConstructor
@Slf4j
public class GiftController {

    private final GiftService giftService;

    @GetMapping
    public ResponseEntity<List<GiftDTO>> getAllGifts(@PathVariable String username) {
        // Логика получения всех подарков пользователя
        try {
            List<GiftDTO> gifts = giftService.getAllUserGifts(username);
            return ResponseEntity.ok(gifts);
        } catch (UserNotFoundException e) {
            log.warn(String.format("User with username = %s not found", username));
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<GiftDTO> addGift(@PathVariable String username, @RequestBody PostGiftRq postGiftRq) {
        // Логика добавления нового подарка
        try {
            var newGift = giftService.createNewGift(username, postGiftRq.getGift());
            return ResponseEntity.status(HttpStatus.CREATED).body(newGift);
        } catch (UserNotFoundException e) {
            log.warn(String.format("User with username = %s not found", username));
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{username}/{giftUId}")
    public ResponseEntity<GiftDTO> getGift(@PathVariable String username, @PathVariable String giftUId) {
        // Логика получения информации о конкретном подарке
        try {
            GiftDTO giftDTO = giftService.getGiftByGiftUId(giftUId);
            return ResponseEntity.ok(giftDTO);
        } catch (GiftNotFoundException e) {
            log.warn(String.format("Gift with giftUId = %s not found", giftUId));
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    //    @PutMapping("/{id}")
//    public ResponseEntity<GiftDTO> updateGift(@PathVariable String username, @PathVariable Long id, @RequestBody PostGiftRq request) {
//        // Логика обновления подарка
//        return ResponseEntity.ok(new GiftDTO());
//    }
//
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGift(@PathVariable String username, @PathVariable String giftUId) {
        // Логика удаления подарка
        try {
            giftService.deleteGift(username, giftUId);
            log.info(String.format("Deleted gift with giftUId = %s, username = %s", giftUId, username));
            return ResponseEntity.ok().build();
        } catch (UserNotFoundException e) {
            log.warn(String.format("User with username = %s not found", username));
            return ResponseEntity.notFound().build();
        } catch (GiftNotFoundException e) {
            log.warn(String.format("Gift with giftUId = %s not found", giftUId));
            return ResponseEntity.notFound().build();
        } catch (WrongUserAndGiftPairException e) {
            log.warn(String.format("WrongUserAndGiftPair: giftUId = %s, username = %s", giftUId, username));
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}