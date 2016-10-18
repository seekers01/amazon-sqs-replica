package app.dao;

import app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sushant on 10/16/16.
 */
@Repository("userDao")
public class UserDao {

    private static final Logger            logger   = LoggerFactory.getLogger(UserDao.class);
    private static final Map<String, User> userPool = new HashMap<>();

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>(0);
        userPool.forEach((K, V) -> users.add(V));
        logger.debug("users: {}", users);
        return users;
    }

    public User getUserByEmail(String email) {
        if (userPool.containsKey(email)) {
            return userPool.get(email);
        }
        return null;
    }

    public void insertNewUser(User newUser) {
        userPool.put(newUser.getEmail(), newUser);
    }

}