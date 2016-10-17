package app.model;

/**
 * Created by sushant on 10/16/16.
 */
public class Application {

    private int    id;
    private String name;

    public Application() {
        super();
    }

    public Application(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
