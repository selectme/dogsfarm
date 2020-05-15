package by.leverx.learn.mudrahelau;

import by.leverx.learn.mudrahelau.model.Farm;
import by.leverx.learn.mudrahelau.model.building.DogsAviary;
import by.leverx.learn.mudrahelau.model.building.TrainingGround;
import by.leverx.learn.mudrahelau.model.dog.RandomDogCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Viktar on 10.05.2020
 */
public class Main {

    private static final int NUMBER_OF_AVIARIES = 5;

    public static void main(String[] args) {

        Farm farm = Farm.getInstance();

        TrainingGround trainingGround = new TrainingGround();
        farm.setTrainingGround(trainingGround);

        farm.setDogsAviaries(generateAviariesWithDogs(NUMBER_OF_AVIARIES));

        farm.startFarmDay();

    }

    private static List<DogsAviary> generateAviariesWithDogs(int numberOfAviaries) {
        List<DogsAviary> generatedAviaries = new ArrayList<>(numberOfAviaries);
        for (int i = 0; i < numberOfAviaries; i++) {
            DogsAviary dogsAviary = new DogsAviary();
            dogsAviary.addDog(RandomDogCreator.createRandomGod());
            generatedAviaries.add(dogsAviary);
        }
        return generatedAviaries;
    }


}
