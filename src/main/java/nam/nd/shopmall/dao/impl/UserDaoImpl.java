package nam.nd.shopmall.dao.impl;

import nam.nd.shopmall.dao.UserDao;
import nam.nd.shopmall.model.User;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nam.nd
 * @created 27/06/2021 - 6:16 PM
 */

@Service
public class UserDaoImpl extends AbstractBaseDAO implements UserDao  {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


    @Override
    public User getUserByEmail(String email) {
        logger.info("---start DAO get User by email:{}", email);
        Query<User> query = getSession().createQuery("select u from User u where u.email=:email", User.class);
        query.setParameter("email", email.trim());
        List<User> userList = query.list();
        return userList.isEmpty() ? null : userList.get(0);
    }
}
