package com.spruce.Blue.users;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(@RequestParam(required = false) String search) {
        return userRepository.findUserByNameContainingIgnoreCase(search);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody @Valid User newUser){
        return userRepository.save(newUser);
    }
}
