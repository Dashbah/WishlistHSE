package dashbah.wishlistapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
@Slf4j
public class HelloController {
    @GetMapping("/")
    public String hello() {
        log.info("hello!");
        return "hello";
    }

    @GetMapping("/error-message")
    public String error() {
        Random rnd = new Random();
        int errorId = rnd.nextInt();
        log.error("Error massage with id = " + errorId);
        return "Error message with id = " + errorId;
    }
}
