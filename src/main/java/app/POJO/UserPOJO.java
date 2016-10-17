package app.POJO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sushant on 10/17/16.
 */
public class UserPOJO {

    private int     id;
    private String  name;
    private String  email;
    private boolean isAdmin; // This would be more complex in case of multi-role system
    private Set<Integer> apps = new HashSet<>(0);

    public UserPOJO() {
        super();
    }

    public UserPOJO(int id, String name, String email, boolean isAdmin, Set<Integer> apps) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
        this.apps = apps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "UserPOJO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", apps=" + apps +
                '}';
    }
}
