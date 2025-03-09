package dashbah.wishlistapp.controller;

import dashbah.wishlistapp.dto.request.UserRegistrationRequest;
import dashbah.wishlistapp.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Логика аутентификации
        return ResponseEntity.ok("Login successful!");
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register-user")
    public String registerUser(@RequestBody UserRegistrationRequest request) {
        // Логика регистрации
//        userService.registerUser(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        return "congrats";
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }
}