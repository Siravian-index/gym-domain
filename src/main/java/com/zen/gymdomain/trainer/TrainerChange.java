package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.trainer.events.TrainerCreated;

import java.util.HashSet;

public class TrainerChange extends EventChange {
    TrainerChange(Trainer trainer) {
        apply((TrainerCreated event) -> {
            trainer.routine = event.getRoutine();
            trainer.clientSet = new HashSet<>();
        });
    }
}
