package com.odev1.odev1.controller;

import com.odev1.odev1.entity.User;
import com.odev1.odev1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    @PostMapping
    public User save(User user){
        return userRepository.save(user);
    }
    @GetMapping
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @GetMapping("{id}")
    public User findById(@PathVariable Long id){
        return userRepository.findById(id).orElse(null);
    }
}
