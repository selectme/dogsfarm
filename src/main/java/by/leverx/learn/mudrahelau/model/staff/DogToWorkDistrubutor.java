package by.leverx.learn.mudrahelau.model.staff;

import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;

/**
 * @author Viktar on 13.05.2020
 */
public class DogToWorkDistrubutor implements StaffWithDogActivity {

    private StaffWithDogActivity staffWithDogActivity;
    @Override
    public void doActivity(Dog dog) {
        staffWithDogActivity.doActivity(dog);
    }

    public void setStaffWithDogActivity(StaffWithDogActivity staffWithDogActivity) {
        this.staffWithDogActivity = staffWithDogActivity;
    }
}
