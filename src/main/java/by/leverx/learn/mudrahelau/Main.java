package by.leverx.learn.mudrahelau;

import by.leverx.learn.mudrahelau.model.*;
import by.leverx.learn.mudrahelau.model.building.DogsAviary;

/**
 * @author Viktar on 10.05.2020
 */
public class Main {

    public static void main(String[] args) {

        Farm farm = Farm.getInstance();

        DogsAviary aviary = new DogsAviary();
        DogsAviary aviary2 = new DogsAviary();
        DogsAviary aviary3 = new DogsAviary();

        Dog dog = new Dog();
        dog.setName("Sharik");
        dog.setAge(0.5);
        dog.setFed(false);
        dog.setHealthy(true);
        dog.setTrained(false);

        Dog dog2 = new Dog();
        dog2.setName("Bublik");
        dog2.setAge(2);
        dog2.setFed(false);
        dog2.setHealthy(true);
        dog2.setTrained(false);

        Dog dog3 = new Dog();
        dog3.setName("Jack");
        dog3.setAge(9);
        dog3.setFed(false);
        dog3.setHealthy(false);
        dog3.setTrained(false);

        farm.addAviary(aviary);
        farm.addAviary(aviary2);
        farm.addAviary(aviary3);

        aviary.addDog(dog);
        aviary2.addDog(dog2);
        aviary3.addDog(dog3);

        farm.feeding();
        farm.healthCheckUp();
        farm.distributeDogs();

        farm.training();

        farm.aviaryCleaning();




    }
}
