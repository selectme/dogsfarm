package by.leverx.learn.mudrahelau.model.staff.staffactivity.impl;

import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;

/**
 * @author Viktar on 10.05.2020
 */
public class HealthCheck implements StaffWithDogActivity {

    public void doActivity(Dog dog) {
        if (!checkIsDogHealthy(dog)) {
            System.out.println("Dog " + dog.getName() + " is sick. Start treatment...");
            dog.setHealthy(true);
            System.out.println("Dog " + dog.getName() + " is healthy");
        } else {
            System.out.println("Dog " + dog.getName() + " is healthy");
        }
    }

    private boolean checkIsDogHealthy(Dog dog) {
        return dog.isHealthy();
    }

}
