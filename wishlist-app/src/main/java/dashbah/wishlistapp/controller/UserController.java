package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // Логика получения списка всех пользователей
        return ResponseEntity.ok(List.of(new UserDto()));
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        // Логика получения информации о конкретном пользователе
        return ResponseEntity.ok(new UserDto());
    }
}