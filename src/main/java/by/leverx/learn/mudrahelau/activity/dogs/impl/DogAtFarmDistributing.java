package by.leverx.learn.mudrahelau.activity.dogs.impl;

import by.leverx.learn.mudrahelau.model.dog.DogAgeType;
import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.model.Farm;
import by.leverx.learn.mudrahelau.activity.dogs.StaffDogActivity;
import by.leverx.learn.mudrahelau.activity.DogTypeDeterminer;

/**
 * @author Viktar on 12.05.2020
 */
public class DogAtFarmDistributing implements StaffDogActivity {
    private Farm farm;

    @Override
    public void doActivity(Dog dog) {
        DogAgeType dogType = DogTypeDeterminer.determineDogType(dog);
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
