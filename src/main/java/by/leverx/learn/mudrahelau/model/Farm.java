package by.leverx.learn.mudrahelau.model;

import by.leverx.learn.mudrahelau.dogtypes.DogTypes;
import by.leverx.learn.mudrahelau.model.building.DogsAviary;
import by.leverx.learn.mudrahelau.model.building.TrainingGround;
import by.leverx.learn.mudrahelau.model.staff.Cleaner;
import by.leverx.learn.mudrahelau.model.staff.Feeder;
import by.leverx.learn.mudrahelau.model.staff.Trainer;
import by.leverx.learn.mudrahelau.model.staff.Veterinarian;
import by.leverx.learn.mudrahelau.util.DogTypeDeterminer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktar on 11.05.2020
 */
public class Farm {

    private List<DogsAviary> dogsAviaries = new ArrayList<>();
    private List<Dog> puppiesToTrain = new ArrayList<>();
    private List<Dog> dogsToWork = new ArrayList<>();

    private TrainingGround trainingGround;

    private StaffWithDogActivity staffActivity;

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

    public void training() {
        Trainer trainer = new Trainer();
        trainer.setStaffActivity(new Training());

        for (Dog dog : puppiesToTrain) {

            trainer.doActivity(dog);
        }
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

    public void aviaryCleaning() {
        Cleaner cleaner = new Cleaner();
        cleaner.setStaffFarmMaintenanceActivity(new Cleaning());

        for (DogsAviary aviary : dogsAviaries) {
            cleaner.doActivity(aviary);
        }
    }

    public void distributeDogs() {
        DogTypes dogType;
        Dog dog;
        for (DogsAviary aviary : dogsAviaries) {
            dog = aviary.getDog();
            dogType = DogTypeDeterminer.determineDogType(dog);
            switch (dogType) {
                case PUPPY:
                    puppiesToTrain.add(dog);
                    aviary.removeDog(dog);
                    break;
                case ADULT:
                    dogsToWork.add(dog);
                    aviary.removeDog(dog);
                    break;
            }
        }
    }


    public List<DogsAviary> getDogsAviaries() {
        return dogsAviaries;
    }

    public void setDogsAviaries(List<DogsAviary> dogsAviaries) {
        this.dogsAviaries = dogsAviaries;
    }

    public TrainingGround getTrainingGround() {
        return trainingGround;
    }

    public void setTrainingGround(TrainingGround trainingGround) {
        this.trainingGround = trainingGround;
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
}
