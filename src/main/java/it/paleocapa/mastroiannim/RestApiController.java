package it.paleocapa.mastroiannim;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.paleocapa.mastroiannim.repository.UserRepository;

@RestController
public class RestApiController {

    @GetMapping("/api")
    public String home() {
        return "Hello from Docker!";
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/users")
    public String findAllUsers() {
        return userRepository.findAll().toString();
    }
}
