package by.leverx.learn.mudrahelau.model;

import by.leverx.learn.mudrahelau.daytimes.DayTime;
import by.leverx.learn.mudrahelau.model.staff.*;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.impl.*;
import by.leverx.learn.mudrahelau.traininggroundstatus.TrainingGroundStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktar on 11.05.2020
 */
public class Farm {

    private List<DogsAviary> dogsAviaries = new ArrayList<>();
    private List<Dog> dogsForWork = new ArrayList<>();
    private List<Dog> dogsForTraining = new ArrayList<>();

    private StaffWithDogActivity staffActivity;
    private TrainingGround trainingGround;
    private DayTime dayTime;


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
        DogAtFarmDistributor dogAtFarmDistributor = new DogAtFarmDistributor();
        dogAtFarmDistributor.setStaffActivity(new DogAtFarmDistributing());

        for (DogsAviary aviary : dogsAviaries) {
            dogAtFarmDistributor.doActivity(aviary.getDog());
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
            System.out.println("Training ground is occupied by " + dog);
            trainingGround.startTraining(trainer, dog);
            trainingGround.setGroundStatus(TrainingGroundStatus.FREE);
            System.out.println("Training ground is free now");
        }
    }

    public void sendDogsToWork() {
        DogToWorkDistrubutor distributor = new DogToWorkDistrubutor();
        distributor.setStaffWithDogActivity(new DogToWorkDistributing());

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

    public void startDaylyTypeActivities(DayTime dayTime) {
        switch (dayTime) {
            case MORNING:
                setDogsHungry();
                feeding();
                healthCheckUp();
                distributeDogs();
                break;
            case AFTERNOON:
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

    public StaffWithDogActivity getStaffActivity() {
        return staffActivity;
    }

    public void setStaffActivity(StaffWithDogActivity staffActivity) {
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
}
