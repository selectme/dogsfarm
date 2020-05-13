package by.leverx.learn.mudrahelau.model.staff.staffactivity.impl;

import by.leverx.learn.mudrahelau.model.Dog;
import by.leverx.learn.mudrahelau.model.staff.staffactivity.StaffWithDogActivity;
import by.leverx.learn.mudrahelau.worktypes.WorkType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Viktar on 13.05.2020
 */
public class DogToWorkDistributing implements StaffWithDogActivity {
    private static final List<WorkType> WORKS_FOR_DOG = Arrays.asList(WorkType.values());
    private static final int SIZE = WORKS_FOR_DOG.size();
    private static final Random RANDOM = new Random();

    @Override
    public void doActivity(Dog dog) {
        WorkType randomWork = WORKS_FOR_DOG.get(RANDOM.nextInt(SIZE));

        switch (randomWork) {
            case POLICE:
                System.out.println("Send " + dog + " to work to police");
                break;
            case RESCUE:
                System.out.println("Send " + dog + " to work to rescue");
        }
    }


}
