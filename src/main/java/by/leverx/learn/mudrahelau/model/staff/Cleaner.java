package by.leverx.learn.mudrahelau.model.staff;

import by.leverx.learn.mudrahelau.model.building.Building;
import by.leverx.learn.mudrahelau.activity.buildings.StaffBuildingActivity;

/**
 * @author Viktar on 13.05.2020
 */
public class Cleaner implements StaffBuildingActivity {

    private StaffBuildingActivity staffBuildingActivity;

    public void setStaffBuildingActivity(StaffBuildingActivity staffBuildingActivity) {
        this.staffBuildingActivity = staffBuildingActivity;
    }

    @Override
    public void maintain(Building building) {
        staffBuildingActivity.maintain(building);
    }
}
