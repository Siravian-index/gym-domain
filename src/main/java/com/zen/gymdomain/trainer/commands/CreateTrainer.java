package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.values.TrainerID;

public class CreateTrainer extends Command {
    private final TrainerID entityId;
    private final Routine routine;

    public CreateTrainer(TrainerID entityId, Routine routine) {
        this.entityId = entityId;
        this.routine = routine;
    }

    public TrainerID getEntityId() {
        return entityId;
    }

    public Routine getRoutine() {
        return routine;
    }
}
