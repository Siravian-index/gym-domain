package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.trainer.events.ClientAdded;
import com.zen.gymdomain.trainer.events.ClientRemoved;
import com.zen.gymdomain.trainer.events.TrainerCreated;

import java.util.HashSet;

public class TrainerChange extends EventChange {
    TrainerChange(Trainer trainer) {
        apply((TrainerCreated event) -> {
            trainer.routine = event.getRoutine();
            trainer.clientSet = new HashSet<>();
        });

        apply((ClientAdded event) -> {
            trainer.clientSet.add(event.getClient());
        });

        apply((ClientRemoved event) -> {
            trainer.clientSet.removeIf(client -> client.identity().equals(event.getClientID()));
        });
    }
}
