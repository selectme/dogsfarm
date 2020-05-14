package by.leverx.learn.mudrahelau.activity.dogs.impl;

import by.leverx.learn.mudrahelau.activity.dogs.StaffDogActivity;
import by.leverx.learn.mudrahelau.model.dog.Dog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.leverx.learn.mudrahelau.common.logger.LoggerMessages.*;

/**
 * @author Viktar on 10.05.2020
 */
public class HealthCheck implements StaffDogActivity {

    private static final Logger logger = LogManager.getLogger(HealthCheck.class);

    public void doActivity(Dog dog) {
        String dogName = dog.getName();
        if (!dog.isHealthy()) {
            logger.info(DOG_IS_SICK, dogName);
            dog.setHealthy(true);
        }
        logger.info(DOG_IS_HEALTHY, dogName);
    }

}
