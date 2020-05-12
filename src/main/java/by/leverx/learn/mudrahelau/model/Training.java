package by.leverx.learn.mudrahelau.model;

/**
 * @author Viktar on 10.05.2020
 */
public class Training implements StaffWithDogActivity {


    public void doActivity(Dog dog) {
        if (!checkIsDogTrained(dog)) {
            System.out.println("Dog " + dog.getName() + " is training...");
            dog.setTrained(true);
            System.out.println("Dog " + dog.getName() + " is trained");
        } else {
            System.out.println("Dog " + dog.getName() + " is already trained");
        }
    }

    private boolean checkIsDogTrained(Dog dog) {
        return dog.isTrained();
    }

}
