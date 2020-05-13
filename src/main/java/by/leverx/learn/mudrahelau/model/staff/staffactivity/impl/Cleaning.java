package by.leverx.learn.mudrahelau.model.staff.staffactivity.impl;

import by.leverx.learn.mudrahelau.model.Building;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffFarmMaintenance;

/**
 * @author Viktar on 13.05.2020
 */
public class Cleaning implements StaffFarmMaintenance {


    @Override
    public void maintain(Building building) {
        System.out.println("Cleaning " + building);
    }
}
