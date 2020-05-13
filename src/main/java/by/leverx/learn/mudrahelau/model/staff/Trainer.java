package by.leverx.learn.mudrahelau.model.staff;

import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;

/**
 * @author Viktar on 10.05.2020
 */
public class Trainer implements StaffWithDogActivity {
    private StaffWithDogActivity staffActivity;

    public void setStaffActivity(StaffWithDogActivity staffActivity) {
        this.staffActivity = staffActivity;
    }

    @Override
    public void doActivity(Dog dog) {
        staffActivity.doActivity(dog);
    }
}
