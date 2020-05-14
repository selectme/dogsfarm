package by.leverx.learn.mudrahelau.activity.buildings.impl;

import by.leverx.learn.mudrahelau.activity.buildings.StaffBuildingActivity;
import by.leverx.learn.mudrahelau.common.logger.LoggerMessages;
import by.leverx.learn.mudrahelau.model.building.Building;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Viktar on 13.05.2020
 */
public class Cleaning implements StaffBuildingActivity {
    private static final Logger logger = LogManager.getLogger(Cleaning.class);

    @Override
    public void maintain(Building building) {
        logger.info(LoggerMessages.CLEANING, building);
    }
}
