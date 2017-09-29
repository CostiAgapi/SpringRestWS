package dao;

import domain.User;
import org.hibernate.SessionFactory;

/**
 * Created by ConstantinAgapi on 26/09/2017.
 */
public interface UserDAO {

    public void create(User user);

    public User getUserByUsername (String username);

    public User getUserByEmail(String email);

}
