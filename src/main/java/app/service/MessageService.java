package app.service;

import app.POJO.SendMessagePOJO;
import app.dao.MessageDao;
import app.dao.QueueDao;
import app.model.Message;
import app.model.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sushant on 10/16/16.
 */

@Service("messageService")
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private QueueDao queueDao;

    public List<Message> getAllMessages() {
        return messageDao.getAllMessages();
    }

    public List<String> sendMessage(SendMessagePOJO request) {
        try {
            if (request.getMessage() == null || request.getMessage().trim() == "") {
                throw new IllegalArgumentException("No message to publish..");
            } else if (request.getQueueList() == null || request.getQueueList().size() < 1) {
                throw new IllegalArgumentException("Invalid queue list to send message to ...");
            }
            List<String> response = new ArrayList<>();
            Message message = messageDao.createNewMessage(request.getMessage());
            for (String uid : request.getQueueList()) {
                Queue queue = queueDao.getQueueByUID(uid);
                if (queue == null) {
                    logger.error("No queue exists for uid: {}", uid);
                    response.add("Invalid UID: " + uid);
                } else {
                    queue.getMessages().add(message.getId());
                    response.add("Message received by queue: " + uid);
                }
            }
            return response;
        } catch (Exception ex) {
            logger.error("Failed to send message.");
            logger.error(ex.getMessage());
            throw new RuntimeException("Failed to send message.");
        }
    }

}
