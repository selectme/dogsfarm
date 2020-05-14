package by.leverx.learn.mudrahelau.model.building;

import by.leverx.learn.mudrahelau.model.dog.Dog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static by.leverx.learn.mudrahelau.common.logger.LoggerMessages.*;

/**
 * @author Viktar on 11.05.2020
 */
public class DogsAviary implements Building {

    private static int aviaryNumberCounter = 1;
    private int aviaryNumber;
    private Dog dog;
    private boolean isClean;
    private static final Logger logger = LogManager.getLogger(DogsAviary.class);

    public DogsAviary() {
        this.aviaryNumber = aviaryNumberCounter;
        aviaryNumberCounter++;
    }

    public void addDog(Dog dog) {
        if (checkIsAviaryEmpty()) {
            this.dog = dog;
        } else {
            logger.info(AVIARY_NO_SPACE, aviaryNumber);
        }
    }

    public void removeDog(Dog dog) {
        if (!checkIsAviaryEmpty()) {
            this.dog = null;
            isClean = false;
        } else {
            logger.info(AVIARY_IS_EMPTY, aviaryNumber);
        }
    }

    public boolean checkIsAviaryEmpty() {
        return this.dog == null;
    }

    public int getAviaryNumber() {
        return aviaryNumber;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    @Override
    public String toString() {
        return "Aviary №" + this.aviaryNumber;
    }
}
