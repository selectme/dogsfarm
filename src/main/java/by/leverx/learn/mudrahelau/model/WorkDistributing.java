package by.leverx.learn.mudrahelau.model;

import by.leverx.learn.mudrahelau.dogtypes.DogTypes;
import by.leverx.learn.mudrahelau.util.DogTypeDeterminer;

/**
 * @author Viktar on 12.05.2020
 */
public class WorkDistributing implements StaffWithDogActivity {

    @Override
    public void doActivity(Dog dog) {
        DogTypes dogType = DogTypeDeterminer.determineDogType(dog);

    }
}
