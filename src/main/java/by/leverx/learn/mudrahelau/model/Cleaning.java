package by.leverx.learn.mudrahelau.model;

import by.leverx.learn.mudrahelau.model.building.Building;

import java.util.List;

/**
 * @author Viktar on 12.05.2020
 */
public class Cleaning implements StaffFarmMaintenanceActivity {

    @Override
    public void doActivity(Building building) {
        System.out.println("Cleaning " + building + "...");
    }
}
