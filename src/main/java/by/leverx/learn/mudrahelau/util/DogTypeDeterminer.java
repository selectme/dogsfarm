package by.leverx.learn.mudrahelau.util;

import by.leverx.learn.mudrahelau.dogtypes.DogTypes;
import by.leverx.learn.mudrahelau.model.Dog;

/**
 * @author Viktar on 10.05.2020
 */
public class DogTypeDeterminer {

    public static DogTypes determineDogType(Dog dog) {
        double age = dog.getAge();

        if (age > 0 && age < 1) {
            return DogTypes.PUPPY;
        } else if (age >= 1 && age < 8) {
            return DogTypes.ADULT;
        } else {
            return DogTypes.OLD;
        }
    }

}
