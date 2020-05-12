package by.leverx.learn.mudrahelau.model.building;

import by.leverx.learn.mudrahelau.model.Dog;

/**
 * @author Viktar on 11.05.2020
 */
public class DogsAviary implements Building {

    private static int aviaryNumberCounter = 1;
    private int aviaryNumber;
    private Dog dog;

    public DogsAviary() {
        this.aviaryNumber = aviaryNumberCounter;
        aviaryNumberCounter++;
    }

    public void addDog(Dog dog) {
        if (checkIsAviaryEmpty()) {
            this.dog = dog;
        } else {
            System.out.println("There is no free space in the aviary №" + aviaryNumber);
        }
    }

    public void removeDog(Dog dog) {
        if (!checkIsAviaryEmpty()) {
            this.dog = null;
        } else {
            System.out.println("Aviary №" + aviaryNumber + " is already empty");
        }
    }

    public boolean checkIsAviaryEmpty() {
        return this.dog == null;
    }

    public int getAviaryNumber() {
        return aviaryNumber;
    }

    public Dog getDog() {
        return dog;
    }


    @Override
    public String toString() {
        return "Aviary №" + this.aviaryNumber;
    }
}
