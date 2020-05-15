package by.leverx.learn.mudrahelau;

import by.leverx.learn.mudrahelau.model.Farm;
import by.leverx.learn.mudrahelau.model.building.DogsAviary;
import by.leverx.learn.mudrahelau.model.building.TrainingGround;
import by.leverx.learn.mudrahelau.model.dog.RandomDogCreator;

/**
 * @author Viktar on 10.05.2020
 */
public class Main {

    public static void main(String[] args) {

        Farm farm = Farm.getInstance();

        TrainingGround trainingGround = new TrainingGround();

        farm.setTrainingGround(trainingGround);

        DogsAviary aviary = new DogsAviary();
        DogsAviary aviary2 = new DogsAviary();
        DogsAviary aviary3 = new DogsAviary();
        DogsAviary aviary4 = new DogsAviary();


        farm.addAviary(aviary);
        farm.addAviary(aviary2);
        farm.addAviary(aviary3);
        farm.addAviary(aviary4);


        for (int i = 0; i < farm.getDogsAviaries().size(); i++) {
            farm.getDogsAviaries().get(i).addDog(RandomDogCreator.createRandomGod());
        }

        farm.startFarmDay();

    }
}
