package app.service;

import app.dao.ApplicationDao;
import app.model.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sushant on 10/16/16.
 */
@Service("applicationService")
public class ApplicationService {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    @Autowired
    private ApplicationDao applicationDao;

    public List<Application> getAllApps() {
        logger.debug("Listing all applications.");
        return applicationDao.getAllApplications();
    }

}
