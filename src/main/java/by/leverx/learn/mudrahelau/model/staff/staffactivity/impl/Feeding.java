package by.leverx.learn.mudrahelau.model.staff.staffactivity.impl;

import by.leverx.learn.mudrahelau.dogtypes.DogTypes;
import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;
import by.leverx.learn.mudrahelau.util.DogTypeDeterminer;

/**
 * @author Viktar on 10.05.2020
 */
public class Feeding implements StaffWithDogActivity {

    public void doActivity(Dog dog) {
        if (!checkIsDogFed(dog)) {
            System.out.println("Dog " + dog.getName() + " is eating " + chooseFoodPortion(dog) + " gram of feed...");
            dog.setFed(true);
            System.out.println("Dog " + dog.getName() + " is fed");
        } else {
            System.out.println("Dog " + dog.getName() + " is not hungry");
        }
    }

    private boolean checkIsDogFed(Dog dog) {
        return dog.isFed();
    }

    private int chooseFoodPortion(Dog dog) {
        DogTypes dogType = DogTypeDeterminer.determineDogType(dog);
        int portion = 0;
        switch (dogType) {
            case PUPPY:
                portion = 80;
                break;
            case ADULT:
                portion = 160;
                break;
            case OLD:
                portion = 120;
                break;

        }
        return portion;
    }


}
