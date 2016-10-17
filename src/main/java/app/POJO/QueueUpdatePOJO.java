package app.POJO;

/**
 * Created by sushant on 10/17/16.
 */
public class QueueUpdatePOJO {

    private String UID;
    private String name;

    public QueueUpdatePOJO() {
        super();
    }

    public QueueUpdatePOJO(String name) {
        this.name = name;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QueueUpdatePOJO{" +
                "UID='" + UID + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
