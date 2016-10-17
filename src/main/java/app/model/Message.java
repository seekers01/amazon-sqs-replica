package app.model;

/**
 * Created by sushant on 10/16/16.
 */
public class Message {

    private static int    maxId;
    private        int    id;
    private        String text;

    public Message() {
        super();
        this.setId();
    }

    public Message(String text) {
        this();
        this.text = text;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        maxId++;
        this.id = maxId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
