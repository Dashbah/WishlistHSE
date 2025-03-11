package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

//    @GetMapping
//    public ResponseEntity<List<UserDTO>> getAllUsers() {
//        // Логика получения списка всех пользователей
//        return ResponseEntity.ok(List.of(new UserDTO()));
//    }
//
//    @GetMapping("/{username}")
//    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
//        // Логика получения информации о конкретном пользователе
//        return ResponseEntity.ok(new UserDTO());
//    }
}