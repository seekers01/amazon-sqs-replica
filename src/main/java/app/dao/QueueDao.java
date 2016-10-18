package app.dao;

import app.POJO.QueueSubscribePOJO;
import app.POJO.QueueUpdatePOJO;
import app.model.Queue;
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

@Repository("queueDao")
public class QueueDao {

    private static final Logger             logger    = LoggerFactory.getLogger(QueueDao.class);
    private static final Map<String, Queue> queuePool = new HashMap<>();

    public List<Queue> getAllQueues() {
        List<Queue> queueList = new ArrayList<>(0);
        queuePool.forEach((K, V) -> queueList.add(V));
        logger.debug("queues: {}", queueList);
        return queueList;
    }

    public Queue getQueueByUID(String uid) {
        if (queuePool.containsKey(uid)) {
            return queuePool.get(uid);
        }
        return null;
    }

    public Queue createNewQueue(Queue request) {
        Queue newQueue = new Queue(request.getName());
        newQueue.setApps(request.getApps());
        queuePool.put(request.getUID(), request);
        return newQueue;
    }

    public Queue updateQueue(QueueUpdatePOJO request) {
        Queue current = queuePool.get(request.getUID());
        current.setName(request.getName());
        return current;
    }

    public void subscribeAppToQueue(QueueSubscribePOJO request) {
        Queue queue = queuePool.get(request.getUID());
        for (int app : request.getApps()) {
            queue.getApps().add(app);
        }
    }

}
