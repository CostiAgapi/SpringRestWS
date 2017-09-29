package controllers;


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

//    public UserController(UserRepository userRepository,
//            BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }

    @RequestMapping(value="/sign-up", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void signUp(@RequestBody User user) {

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