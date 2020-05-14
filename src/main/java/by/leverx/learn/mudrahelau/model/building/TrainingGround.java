package by.leverx.learn.mudrahelau.model.building;

import by.leverx.learn.mudrahelau.model.dog.Dog;
import by.leverx.learn.mudrahelau.model.staff.Trainer;

/**
 * @author Viktar on 13.05.2020
 */
public class TrainingGround implements Building {

    private Trainer trainer;
    private TrainingGroundStatus groundStatus;


    public void startTraining(Trainer trainer, Dog dog){
        trainer.doActivity(dog);
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public TrainingGroundStatus getGroundStatus() {
        return groundStatus;
    }

    public void setGroundStatus(TrainingGroundStatus groundStatus) {
        this.groundStatus = groundStatus;
    }

    @Override
    public String toString() {
        return "Training ground";
    }
}
