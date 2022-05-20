package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.values.TrainerID;

public class TrainerCreated extends DomainEvent {
    private final TrainerID trainerID;
    private final Routine routine;

    public TrainerCreated(TrainerID trainerID, Routine routine) {
        super("com.zen.gymdomain.trainer.trainercreated");
        this.trainerID = trainerID;
        this.routine = routine;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Routine getRoutine() {
        return routine;
    }
}
