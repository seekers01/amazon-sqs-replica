package app.controller;

import app.POJO.SendMessagePOJO;
import app.model.Message;
import app.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sushant on 10/16/16.
 */

@RestController
@RequestMapping("/msg")
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Message>> receiveMessages() {
        try {
            return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Failed to fetch messages.");
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<String>> sendMessage(@RequestBody SendMessagePOJO request) {
        try {
            return new ResponseEntity<>(messageService.sendMessage(request), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("");
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateMessage() {
        //TODO:
    }
}
