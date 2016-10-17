package app.service;

import app.POJO.QueueSubscribePOJO;
import app.POJO.QueueUpdatePOJO;
import app.dao.QueueDao;
import app.model.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sushant on 10/16/16.
 */

@Service("queueService")
public class QueueService {

    private static final Logger logger = LoggerFactory.getLogger(QueueService.class);

    @Autowired
    private QueueDao queueDao;

    public List<Queue> getAllQueues() {
        try {
            return queueDao.getAllQueues();
        } catch (Exception ex) {
            logger.error("Failed to retrieve queues.");
            logger.error(ex.getMessage());
            throw new RuntimeException("Failed to retrieve queues.");
        }
    }

    public Queue createNewQueue(Queue request) {
        try {
            if (request.getName() == null || request.getId() != 0 || request.getUID() != null) {
                logger.error("Invalid queue creation request.");
                throw new IllegalArgumentException("Invalid queue creation request.");
            }
            queueDao.createNewQueue(request);
        } catch (Exception ex) {
            logger.error("Failed to create new queue.");
            logger.error(ex.getMessage());
            throw new RuntimeException("Failed to create new queue.");
        }
        return null;
    }

    public Queue updateQueue(QueueUpdatePOJO request) {
        try {
            Queue current = queueDao.getQueueByUID(request.getUID());
            if (current == null) {
                throw new IllegalArgumentException("No such queue exists");
            } else {
                queueDao.updateQueue(request);
            }
            return current;
        } catch (Exception ex) {
            logger.error("Failed to update queue.");
            logger.error(ex.getMessage());
            throw new RuntimeException("Failed to update queue.");
        }
    }

    public Queue subscribe(QueueSubscribePOJO request) {
        Queue current = queueDao.getQueueByUID(request.getUID());
        if (current == null) {
            throw new IllegalArgumentException("No such queue exists.");
        } else {
            queueDao.subscribeAppToQueue(request);
        }
        return current;
    }

}
