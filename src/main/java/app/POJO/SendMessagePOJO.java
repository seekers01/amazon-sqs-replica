package app.POJO;

import java.util.List;

/**
 * Created by sushant on 10/17/16.
 */
public class SendMessagePOJO {

    private String       message;
    private List<String> queueList;

    public SendMessagePOJO() {
        super();
    }

    public SendMessagePOJO(String message, List<String> queueList) {
        this.message = message;
        this.queueList = queueList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getQueueList() {
        return queueList;
    }

    public void setQueueList(List<String> queueList) {
        this.queueList = queueList;
    }

    @Override
    public String toString() {
        return "SendMessagePOJO{" +
                "message='" + message + '\'' +
                ", queueList=" + queueList +
                '}';
    }
}
