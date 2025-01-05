package uz.muydinov.springsecuritynew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.muydinov.springsecuritynew.entity.Users;
import uz.muydinov.springsecuritynew.service.UserService;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {
        return userService.verify(user);
    }
}
