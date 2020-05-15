package by.leverx.learn.mudrahelau.activity.dogs.impl;

import by.leverx.learn.mudrahelau.activity.dogs.StaffDogActivity;
import by.leverx.learn.mudrahelau.model.dog.DogAgeType;
import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.activity.DogTypeDeterminer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.leverx.learn.mudrahelau.common.logger.LoggerMessages.*;

/**
 * @author Viktar on 10.05.2020
 */
public class Training implements StaffDogActivity {

    private static final Logger logger = LogManager.getLogger(Training.class);

    public void doActivity(Dog dog) {
        DogAgeType dogType = DogTypeDeterminer.determineDogType(dog);
        if (dogType == DogAgeType.PUPPY) {
            if (!dog.isTrained()) {
                logger.info(DOG_IS_TRAINING, dog.getName());
                dog.setTrained(true);
            }
            logger.info(DOG_IS_TRAINED, dog.getName());
        }
    }

}
