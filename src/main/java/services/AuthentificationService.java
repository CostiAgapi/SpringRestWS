package services;

import domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by ConstantinAgapi on 22/09/2017.
 */
@Service
public class AuthentificationService {

     public boolean authentificateUser(User user){
         if(user.getUsername().equals("costi")){
            return true;
         }else{
             return false;
         }
     }

}
