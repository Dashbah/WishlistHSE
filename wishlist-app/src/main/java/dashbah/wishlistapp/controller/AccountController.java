package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.UserDto;
import dashbah.wishlistapp.dto.request.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public ResponseEntity<UserDto> getAccount() {
        // Логика получения информации о текущем пользователе
        return ResponseEntity.ok(new UserDto());
    }

    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody UserUpdateRequest request) {
        // Логика обновления информации о пользователе
        return ResponseEntity.ok("Account updated");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAccount() {
        // Логика удаления аккаунта
        return ResponseEntity.noContent().build();
    }
}