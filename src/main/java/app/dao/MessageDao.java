package app.dao;

import app.model.Message;
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
@Repository("messageDao")
public class MessageDao {

    private static final Logger                logger      = LoggerFactory.getLogger(MessageDao.class);
    private static final Map<Integer, Message> messagePool = new HashMap<>();

    public List<Message> getAllMessages() {
        List<Message> messages = new ArrayList<>(0);
        messagePool.forEach((K, V) -> messages.add(V));
        logger.debug("messages: {}", messages);
        return messages;
    }

    public Message createNewMessage(String text) {
        Message message = new Message(text);
        logger.info("Message received. Message: {}", message);
        messagePool.put(message.getId(), message);
        return message;
    }

}
