package dao;

import java.util.List;

import domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ConstantinAgapi on 26/09/2017.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserByUsername(final String username) {
        User user = (User)sessionFactory.getCurrentSession().createQuery("from User as c where c.username = :username").setParameter("username",username).uniqueResult();
       return user;
    }

    @Override
    public User getUserByEmail(final String email) {
        return null;
    }
}
