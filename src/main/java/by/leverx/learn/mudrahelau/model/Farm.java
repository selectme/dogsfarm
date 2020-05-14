package by.leverx.learn.mudrahelau.model;

import by.leverx.learn.mudrahelau.activity.buildings.impl.Cleaning;
import by.leverx.learn.mudrahelau.activity.dogs.*;
import by.leverx.learn.mudrahelau.activity.dogs.impl.*;
import by.leverx.learn.mudrahelau.model.building.DogsAviary;
import by.leverx.learn.mudrahelau.model.building.TrainingGround;
import by.leverx.learn.mudrahelau.model.building.TrainingGroundStatus;
import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.model.staff.*;
import by.leverx.learn.mudrahelau.activity.buildings.StaffBuildingActivity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static by.leverx.learn.mudrahelau.common.logger.LoggerMessages.*;

/**
 * @author Viktar on 11.05.2020
 */
public class Farm {

    private List<DogsAviary> dogsAviaries = new ArrayList<>();
    private List<Dog> dogsForWork = new ArrayList<>();
    private List<Dog> dogsForTraining = new ArrayList<>();

    private StaffDogActivity staffActivity;
    private StaffBuildingActivity staffBuildingActivity;
    private TrainingGround trainingGround;
    private DayTime dayTime;
    private static final Logger logger = LogManager.getLogger(Farm.class);


    private static Farm farm;


    public static Farm getInstance() {
        if (farm == null) {
            farm = new Farm();
        }
        return farm;
    }

    public void addAviary(DogsAviary dogsAviary) {
        dogsAviaries.add(dogsAviary);
    }


    public void feeding() {
        Feeder feeder = new Feeder();
        feeder.setStaffActivity(new Feeding());

        for (DogsAviary aviary : dogsAviaries) {
            if (!aviary.checkIsAviaryEmpty())
                feeder.doActivity(aviary.getDog());
        }
    }

    public void healthCheckUp() {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setStaffActivity(new HealthCheck());

        for (DogsAviary aviary : dogsAviaries) {
            if (!aviary.checkIsAviaryEmpty())
                veterinarian.doActivity(aviary.getDog());
        }
    }


    public void distributeDogs() {
        Distributor distributor = new Distributor();
        distributor.setStaffActivity(new DogAtFarmDistributing());

        for (DogsAviary aviary : dogsAviaries) {
            distributor.doActivity(aviary.getDog());
        }

        for (DogsAviary aviary : dogsAviaries) {
            for (Dog dogForTraining : dogsForTraining) {
                if (dogForTraining.equals(aviary.getDog())) {
                    aviary.removeDog(dogForTraining);
                }
            }
        }

        for (DogsAviary aviary : dogsAviaries) {
            for (Dog dogForWork : dogsForWork) {
                if (dogForWork.equals(aviary.getDog())) {
                    aviary.removeDog(dogForWork);
                }
            }
        }
    }

    public void training(TrainingGround trainingGround) {
        this.trainingGround = trainingGround;
        Trainer trainer = new Trainer();
        trainer.setStaffActivity(new Training());

        for (Dog dog : dogsForTraining) {
            trainingGround.setGroundStatus(TrainingGroundStatus.OCCUPIED);
            logger.info(OCCUPIED_TRAINING_GROUND, dog);
            trainingGround.startTraining(trainer, dog);
            trainingGround.setGroundStatus(TrainingGroundStatus.FREE);
            logger.info(FREE_TRAINING_GROUND);
        }
    }

    public void sendDogsToWork() {
        Distributor distributor = new Distributor();
        distributor.setStaffActivity(new DogToWorkDistributing());

        for (Dog dog : dogsForWork) {
            distributor.doActivity(dog);
        }
    }

    public void returnDogsToAviaries() {

        for (Dog dog : dogsForTraining) {
            for (DogsAviary aviary : dogsAviaries) {
                if (aviary.checkIsAviaryEmpty()) {
                    aviary.addDog(dog);
                    break;
                }
            }
        }

        for (Dog dog : dogsForWork) {
            for (DogsAviary aviary : dogsAviaries) {
                if (aviary.checkIsAviaryEmpty()) {
                    aviary.addDog(dog);
                    break;
                }
            }
        }
    }

    public void cleaning(){
        Cleaner cleaner = new Cleaner();
        cleaner.setStaffBuildingActivity(new Cleaning());

        for(DogsAviary aviary : dogsAviaries){
            cleaner.maintain(aviary);
        }
    }

    public void startDailyTypeActivities(DayTime dayTime) {
        switch (dayTime) {
            case MORNING:
                setDogsHungry();
                feeding();
                healthCheckUp();
                distributeDogs();
                break;
            case AFTERNOON:
                cleaning();
                training(trainingGround);
                sendDogsToWork();
                break;
            case EVENING:
                returnDogsToAviaries();
                setDogsHungry();
                feeding();
                break;
        }
    }

    public void setDogsHungry() {
        for (DogsAviary aviary : dogsAviaries) {
            aviary.getDog().setFed(false);
        }
    }

    public TrainingGround getTrainingGround() {
        return trainingGround;
    }

    public void setTrainingGround(TrainingGround trainingGround) {
        this.trainingGround = trainingGround;
    }

    public List<Dog> getDogsForWork() {
        return dogsForWork;
    }

    public List<Dog> getDogsForTraining() {
        return dogsForTraining;
    }

    public List<DogsAviary> getDogsAviaries() {
        return dogsAviaries;
    }

    public void setDogsAviaries(List<DogsAviary> dogsAviaries) {
        this.dogsAviaries = dogsAviaries;
    }

    public StaffDogActivity getStaffActivity() {
        return staffActivity;
    }

    public void setStaffActivity(StaffDogActivity staffActivity) {
        this.staffActivity = staffActivity;
    }

    public static Farm getFarm() {
        return farm;
    }

    public static void setFarm(Farm farm) {
        Farm.farm = farm;
    }

    public DayTime getDayTime() {
        return dayTime;
    }

    public void setDayTime(DayTime dayTime) {
        this.dayTime = dayTime;
    }

    public StaffBuildingActivity getStaffBuildingActivity() {
        return staffBuildingActivity;
    }

    public void setStaffBuildingActivity(StaffBuildingActivity staffBuildingActivity) {
        this.staffBuildingActivity = staffBuildingActivity;
    }
}
