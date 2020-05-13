package by.leverx.learn.mudrahelau.model.staff.staffactivity.impl;

import by.leverx.learn.mudrahelau.dogtypes.DogTypes;
import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;
import by.leverx.learn.mudrahelau.util.DogTypeDeterminer;

/**
 * @author Viktar on 10.05.2020
 */
public class Training implements StaffWithDogActivity {


    public void doActivity(Dog dog) {
        DogTypes dogType = DogTypeDeterminer.determineDogType(dog);
        if (dogType == DogTypes.PUPPY) {
            if (!checkIsDogTrained(dog)) {
                System.out.println("Dog " + dog.getName() + " is training...");
                dog.setTrained(true);
                System.out.println("Dog " + dog.getName() + " is trained");
            } else {
                System.out.println("Dog " + dog.getName() + " is already trained");
            }
        }
    }

    private boolean checkIsDogTrained(Dog dog) {
        return dog.isTrained();
    }

}
