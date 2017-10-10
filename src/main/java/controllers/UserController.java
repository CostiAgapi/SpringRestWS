package controllers;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDAO;
import domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ConstantinAgapi on 25/09/2017.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userRepository;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value="/sign-up", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void signUp(@RequestBody String userJson) {
//        userRepository.get
//        if()
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(userJson, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.create(user);
    }

    //TODO decide implementation for logout (client side or put jwt token in cookie not in header)

//    @RequestMapping(value="/log-out", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void logOut(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }
}