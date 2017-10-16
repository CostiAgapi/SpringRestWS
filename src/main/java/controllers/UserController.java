package controllers;


import static security.SecurityConstants.EXPIRATION_TIME;
import static security.SecurityConstants.HEADER_STRING;
import static security.SecurityConstants.SECRET;
import static security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserDAO;
import domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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
    public void signUp(@RequestBody String userJson,HttpServletResponse response) {

        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(userJson, User.class);
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(userRepository.getUserByEmail(user.getEmail())==null) {
            userRepository.create(user);
            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS512, SECRET)
                    .compact();
            response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        }
    }

    //TODO decide implementation for logout (client side or put jwt token in cookie not in header)

//    @RequestMapping(value="/log-out", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void logOut(HttpServletRequest request) {
//        request.getSession().invalidate();
//    }
}