package controllers;

import com.sun.net.httpserver.Authenticator;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.AuthentificationService;

/**
 * Created by ConstantinAgapi on 22/09/2017.
 */
@CrossOrigin
@RestController
public class LogInController {

    @Autowired
    AuthentificationService authentificationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<User> logIn(@RequestBody User user){

        if(authentificationService.authentificateUser(user)){
            return new ResponseEntity<User>(user ,HttpStatus.OK);
        }else {
            return new ResponseEntity<User>(user ,HttpStatus.NOT_FOUND);
        }
    }
}
