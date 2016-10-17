package app.POJO;

import java.util.List;

/**
 * Created by sushant on 10/17/16.
 */
public class QueueSubscribePOJO {

    private String        UID;
    private List<Integer> apps;

    public QueueSubscribePOJO() {
        super();
    }

    public QueueSubscribePOJO(String UID, List<Integer> apps) {
        this.UID = UID;
        this.apps = apps;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public List<Integer> getApps() {
        return apps;
    }

    public void setApps(List<Integer> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "QueueSubscribePOJO{" +
                "UID=" + UID +
                "apps=" + apps +
                '}';
    }
}
