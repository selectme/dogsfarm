package by.leverx.learn.mudrahelau.model.staff;

import by.leverx.learn.mudrahelau.model.Building;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffFarmMaintenance;

/**
 * @author Viktar on 13.05.2020
 */
public class Cleaner implements StaffFarmMaintenance {

    private StaffFarmMaintenance staffFarmMaintenance;

    public void setStaffFarmMaintenance(StaffFarmMaintenance staffFarmMaintenance) {
        this.staffFarmMaintenance = staffFarmMaintenance;
    }

    @Override
    public void maintain(Building building) {
        staffFarmMaintenance.maintain(building);
    }
}
