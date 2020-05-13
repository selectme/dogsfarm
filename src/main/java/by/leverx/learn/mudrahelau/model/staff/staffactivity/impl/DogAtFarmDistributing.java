package by.leverx.learn.mudrahelau.model.staff.staffactivity.impl;

import by.leverx.learn.mudrahelau.dogtypes.DogTypes;
import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.Farm;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;
import by.leverx.learn.mudrahelau.util.DogTypeDeterminer;

/**
 * @author Viktar on 12.05.2020
 */
public class DogAtFarmDistributing implements StaffWithDogActivity {
    private Farm farm;

    @Override
    public void doActivity(Dog dog) {
        DogTypes dogType = DogTypeDeterminer.determineDogType(dog);
        farm = Farm.getInstance();
        switch (dogType) {
            case PUPPY:
                farm.getDogsForTraining().add(dog);
                break;
            case ADULT:
                farm.getDogsForWork().add(dog);
                break;
        }


    }
}
