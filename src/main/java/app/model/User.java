package app.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sushant on 10/16/16.
 */
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private static int     maxId;
    private        int     id;
    private        String  name;
    private        String  email;
    private        boolean isAdmin; // This would be more complex in case of multi-role system
    private Set<Integer> apps = new HashSet<>(0);

    public User() {
        super();
        this.setId();
    }

    public int getId() {
        return id;
    }

    private void setId() {
        maxId++;
        logger.info("User.maxId: {}", maxId);
        this.id = maxId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Set<Integer> getApps() {
        return apps;
    }

    public void setApps(Set<Integer> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", apps=" + apps +
                '}';
    }
}
