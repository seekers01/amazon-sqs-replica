package app.controller;

import app.model.Application;
import app.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sushant on 10/16/16.
 */

@RestController
@RequestMapping("/apps")
public class ApplicationController {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Application>> getApplications() {
        try {
            return new ResponseEntity<>(applicationService.getAllApps(), HttpStatus.OK);
        } catch (Exception ex) {
            logger.error("Failed to get users list.");
            logger.error(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createApplication() {
        // TODO:
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateApplication() {
        // TODO:
    }
}
