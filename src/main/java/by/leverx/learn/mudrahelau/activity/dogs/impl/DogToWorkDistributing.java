package by.leverx.learn.mudrahelau.activity.dogs.impl;

import by.leverx.learn.mudrahelau.activity.dogs.StaffDogActivity;
import by.leverx.learn.mudrahelau.common.logger.LoggerMessages;
import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.model.dog.WorkType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Viktar on 13.05.2020
 */
public class DogToWorkDistributing implements StaffDogActivity {
    private static final List<WorkType> WORKS_FOR_DOG = Arrays.asList(WorkType.values());
    private static final int SIZE = WORKS_FOR_DOG.size();
    private static final Random RANDOM = new Random();
    private static final Logger logger = LogManager.getLogger(DogToWorkDistributing.class);

    @Override
    public void doActivity(Dog dog) {
        WorkType randomWork = WORKS_FOR_DOG.get(RANDOM.nextInt(SIZE));

        switch (randomWork) {
            case POLICE:
                logger.info(LoggerMessages.SEND_DOG_TO_POLICE, dog);
                break;
            case RESCUE:
                logger.info(LoggerMessages.SEND_DOG_TO_RESCUE, dog);
                break;
        }
    }


}
