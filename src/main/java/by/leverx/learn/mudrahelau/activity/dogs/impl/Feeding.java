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
public class Feeding implements StaffDogActivity {

    private static final Logger logger = LogManager.getLogger(Feeding.class);
    private static final int PORTION_FOR_PUPPY = 90;
    private static final int PORTION_FOR_ADULT = 150;
    private static final int PORTION_FOR_OLD = 130;

    public void doActivity(Dog dog) {
        if (!checkIsDogFed(dog)) {
            logger.info(DOG_IS_EATING, dog.getName(), chooseFoodPortion(dog));
            dog.setFed(true);
            logger.info(DOG_IS_FED, dog.getName());
        } else {
            logger.info(DOG_IS_NOT_HUNGRY, dog.getName());
        }
    }

    private boolean checkIsDogFed(Dog dog) {
        return dog.isFed();
    }

    private int chooseFoodPortion(Dog dog) {
        DogAgeType dogType = DogTypeDeterminer.determineDogType(dog);

        switch (dogType) {
            case PUPPY:
                return PORTION_FOR_PUPPY;
            case ADULT:
                return PORTION_FOR_ADULT;
            case OLD:
                return PORTION_FOR_OLD;
            default:
                throw new IllegalStateException("Unknown portion for the type " + dogType);
        }
    }


}
