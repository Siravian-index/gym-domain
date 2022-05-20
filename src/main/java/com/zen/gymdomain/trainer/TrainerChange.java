package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.events.*;

import java.util.HashSet;

public class TrainerChange extends EventChange {
    TrainerChange(Trainer trainer) {
        apply((TrainerCreated event) -> {
            trainer.routine = event.getRoutine();
            trainer.clientSet = new HashSet<>();
        });

        apply((ClientAdded event) -> {
//            toca crear el cliente aca con los objectos de valor
//            y despues agregarlo al Set
            trainer.clientSet.add(event.getClient());
        });

        apply((ClientRemoved event) -> {
            trainer.clientSet.removeIf(client -> client.identity().equals(event.getClientID()));
        });

        apply((ClientFitnessLevelUpdated event) -> {
            Client client = trainer.findClientById(event.getClientID()).orElseThrow();
            client.updateFitnessLevel(event.getFitnessLevel());
        });

        apply((ClientPhoneNumberUpdated event) -> {
            Client client = trainer.findClientById(event.getClientID()).orElseThrow();
            client.updatePhoneNumber(event.getPhoneNumber());
        });

        apply((ClientNameUpdated event) -> {
            Client client = trainer.findClientById(event.getClientID()).orElseThrow();
            client.updateName(event.getName());
        });

        apply((RoutineAdded event) -> {
            trainer.routine = event.getRoutine();
        });

        apply((RoutineDescriptionUpdated event) -> {
            trainer.routine.updateDescription(event.getDescription());
        });

        apply((RoutineIsCompletedUpdated event) -> {
            trainer.routine.updateIsCompleted(event.getIsCompleted());
        });

        apply((RoutineTypeUpdated event) -> {
            trainer.routine.updateType(event.getType());
        });
    }
}
