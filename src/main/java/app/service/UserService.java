package app.service;

import app.POJO.UserPOJO;
import app.dao.UserDao;
import app.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sushant on 10/16/16.
 */
@Service("userService")
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public int createUser(UserPOJO request) {
        User user = userDao.getUserByEmail(request.getEmail());
        if (user == null) {
            User newUser = new User();
            newUser.setName(request.getName());
            newUser.setEmail(request.getEmail());
            newUser.setIsAdmin(request.isAdmin());
            userDao.insertNewUser(newUser);
            return newUser.getId();
        } else {
            return user.getId();
        }
    }

    // Flaw: Any user can invoke update if he/she knows the email of id of another user.
    public User updateUser(UserPOJO request) {
        User user = userDao.getUserByEmail(request.getEmail());
        if (user == null) {
            logger.error("User does not exist. request:{}", request);
            throw new RuntimeException("User does not exist.");
        } else {
            user.setApps(request.getApps());
            user.setName(request.getName());
            // TODO: updating admin functionality is just not available
//            user.setIsAdmin(request.isAdmin());
            return user;
        }
    }

}
