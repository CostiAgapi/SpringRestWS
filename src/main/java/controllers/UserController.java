package controllers;

import static security.SecurityConstants.PASSWORD;
import static security.SecurityConstants.USERNAME;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import dao.UserRepository;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import security.SecurityConstants;

/**
 * Created by ConstantinAgapi on 25/09/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    public UserController(UserRepository userRepository,
//            BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @RequestMapping(value="/sign-up", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        USERNAME = user.getUsername();
        PASSWORD = user.getPassword();
        System.out.println(USERNAME+PASSWORD);
    }

    //TODO decide implementation for logout (client side or put jwt token in cookie not in header)

//    @RequestMapping(value="/log-out", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void logOut(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }
}