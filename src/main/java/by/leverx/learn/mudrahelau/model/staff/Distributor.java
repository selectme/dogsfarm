package by.leverx.learn.mudrahelau.model.staff;

import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.activity.dogs.StaffDogActivity;

/**
 * @author Viktar on 12.05.2020
 */
public class Distributor implements StaffDogActivity {
    private StaffDogActivity staffActivity;

    public void setStaffActivity(StaffDogActivity staffActivity) {
        this.staffActivity = staffActivity;
    }

    @Override
    public void doActivity(Dog dog) {
        staffActivity.doActivity(dog);
    }
}
