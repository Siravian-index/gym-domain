package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.TrainerID;

public class TrainerCreated extends DomainEvent {
    private final TrainerID trainerID;
    private final Name name;


    public TrainerCreated(TrainerID trainerID, Name name) {
        super("com.zen.gymdomain.trainer.trainercreated");
        this.trainerID = trainerID;
        this.name = name;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Name getName() {
        return this.name;
    }
}
