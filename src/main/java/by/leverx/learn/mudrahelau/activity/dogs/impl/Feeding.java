package by.leverx.learn.mudrahelau.activity.dogs.impl;

import by.leverx.learn.mudrahelau.activity.DogTypeDeterminer;
import by.leverx.learn.mudrahelau.activity.dogs.StaffDogActivity;
import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.model.dog.DogAgeType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.leverx.learn.mudrahelau.common.logger.LoggerMessages.DOG_IS_EATING;
import static by.leverx.learn.mudrahelau.common.logger.LoggerMessages.DOG_IS_NOT_HUNGRY;

/**
 * @author Viktar on 10.05.2020
 */
public class Feeding implements StaffDogActivity {

    private static final Logger logger = LogManager.getLogger(Feeding.class);
    private static final int PORTION_FOR_PUPPY = 90;
    private static final int PORTION_FOR_ADULT = 150;
    private static final int PORTION_FOR_OLD = 130;
    private static String UNKNOWN_PORTION_OF_FOOD = "Unknown portion for the type ";

    public void doActivity(Dog dog) {
        if (!dog.isFed()) {
            logger.info(DOG_IS_EATING, dog.getName(), chooseFoodPortion(dog));
            dog.setFed(true);
        }
        logger.info(DOG_IS_NOT_HUNGRY, dog.getName());
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
                throw new IllegalStateException(UNKNOWN_PORTION_OF_FOOD + dogType);
        }
    }


}
