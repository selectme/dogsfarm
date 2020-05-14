package by.leverx.learn.mudrahelau.activity;

import by.leverx.learn.mudrahelau.model.dog.DogAgeType;
import by.leverx.learn.mudrahelau.model.dog.Dog;

/**
 * @author Viktar on 10.05.2020
 */
public class DogTypeDeterminer {
    private static final double MIN_PUPPY_AGE = 0;
    private static final double MAX_PUPPY_AGE = 1;
    private static final double MIN_ADULT_DOG_AGE = 1;
    private static final double MAX_ADULT_DOG_AGE = 8;

    public static DogAgeType determineDogType(Dog dog) {
        double age = dog.getAge();

        if (age > MIN_PUPPY_AGE && age < MAX_PUPPY_AGE) {
            return DogAgeType.PUPPY;
        } else if (age >= MIN_ADULT_DOG_AGE && age < MAX_ADULT_DOG_AGE) {
            return DogAgeType.ADULT;
        } else {
            return DogAgeType.OLD;
        }
    }

}
