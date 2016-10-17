package app.controller;

import app.POJO.QueueSubscribePOJO;
import app.POJO.QueueUpdatePOJO;
import app.model.Queue;
import app.service.QueueService;
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
@RequestMapping("/queue")
public class QueueController {

    private static final Logger logger = LoggerFactory.getLogger(QueueController.class);

    @Autowired
    private QueueService queueService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Queue>> getQueues() {
        try {
            return new ResponseEntity<>(queueService.getAllQueues(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Failed to get queue list.");
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Queue> createQueue(@RequestBody Queue request) {
        try {
            return new ResponseEntity<>(queueService.createNewQueue(request), HttpStatus.OK);
        } catch (IllegalArgumentException iae) {
            logger.error(iae.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            logger.error("Failed to get queue list.");
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Queue> updateQueue(@RequestBody QueueUpdatePOJO request) {
        try {
            return new ResponseEntity<>(queueService.updateQueue(request), HttpStatus.OK);
        } catch (IllegalArgumentException iae) {
            logger.error(iae.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            logger.error("Failed to update queue with request: {}", request);
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/subscribe", method = RequestMethod.PUT)
    public ResponseEntity<Queue> subscribe(@RequestBody QueueSubscribePOJO request) {
        try {
            queueService.subscribe(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException iae) {
            logger.error(iae.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception ex) {
            logger.error("");
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
