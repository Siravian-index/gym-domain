package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.values.TrainerID;

public class AddRoutine extends Command {
    private final TrainerID trainerID;
    private final Routine routine;

    public AddRoutine(TrainerID trainerID, Routine routine) {
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
