package org.mishka.authorizationservice.rest;

import org.mishka.authorizationservice.data.Users;
import org.mishka.authorizationservice.data.UsersRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestService {

    private final UsersRepo userRepository;

    public RestService(UsersRepo userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return (List<Users>) userRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody Users user) {
        userRepository.save(user);
    }
}