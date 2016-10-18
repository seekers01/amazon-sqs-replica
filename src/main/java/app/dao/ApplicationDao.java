package app.dao;

import app.model.Application;
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
@Repository("applicationDao")
public class ApplicationDao {

    private static final Logger                    logger          = LoggerFactory.getLogger(ApplicationDao.class);
    private static final Map<Integer, Application> applicationPool = new HashMap<>();

    static {
        applicationPool.put(1, new Application(1, "app1"));
        applicationPool.put(2, new Application(2, "app2"));
        applicationPool.put(3, new Application(3, "app3"));
        applicationPool.put(4, new Application(4, "app4"));
    }

    public List<Application> getAllApplications() {
        List<Application> apps = new ArrayList<>(0);
        applicationPool.forEach((K, V) -> apps.add(V));
        logger.debug("Apps: {}", apps);
        return apps;
    }

}
