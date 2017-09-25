package controllers;

import static security.SecurityConstants.PASSWORD;
import static security.SecurityConstants.USERNAME;

import dao.UserRepository;
import domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import security.SecurityConstants;

/**
 * Created by ConstantinAgapi on 25/09/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    @ResponseStatus(value = HttpStatus.OK)
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        USERNAME = user.getUsername();
        PASSWORD = user.getPassword();
        System.out.println(USERNAME+PASSWORD);
    }
}