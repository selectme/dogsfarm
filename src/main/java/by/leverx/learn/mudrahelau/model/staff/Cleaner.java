package by.leverx.learn.mudrahelau.model.staff;

import by.leverx.learn.mudrahelau.model.StaffFarmMaintenanceActivity;
import by.leverx.learn.mudrahelau.model.building.Building;

import java.util.List;

/**
 * @author Viktar on 12.05.2020
 */
public class Cleaner implements StaffFarmMaintenanceActivity {

    private StaffFarmMaintenanceActivity staffFarmMaintenanceActivity;

    public void setStaffFarmMaintenanceActivity(StaffFarmMaintenanceActivity staffFarmMaintenanceActivity) {
        this.staffFarmMaintenanceActivity = staffFarmMaintenanceActivity;
    }

    @Override
    public void doActivity(Building building) {
        staffFarmMaintenanceActivity.doActivity(building);
    }
}
