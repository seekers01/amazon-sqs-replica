package app.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sushant on 10/16/16.
 */

public class Queue {

    private static int          maxId;
    private        int          id;
    private        String       UID;
    private        String       name;
    private        Set<Integer> messages;
    private        Set<Integer> apps;

    public Queue() {
        super();
        this.setId();
        this.apps = new HashSet<>(0);
    }

    public Queue(String name) {
        super();
        this.setId();
        this.name = name;
        this.UID = this.id + "-" + this.name;
        this.apps = new HashSet<>(0);
    }

    public int getId() {
        return id;
    }

    private void setId() {
        maxId++;
        this.id = maxId;
    }

    public String getUID() {
        return UID;
    }

    private void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getMessages() {
        return messages;
    }

    public void setMessages(Set<Integer> messages) {
        this.messages = messages;
    }

    public Set<Integer> getApps() {
        return apps;
    }

    public void setApps(Set<Integer> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "id=" + id +
                ", UID='" + UID + '\'' +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                ", apps=" + apps +
                '}';
    }

}
