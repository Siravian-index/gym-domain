package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.events.TrainerCreated;
import com.zen.gymdomain.trainer.values.TrainerID;

import java.util.List;
import java.util.Set;

public class Trainer extends AggregateEvent<TrainerID> {
    protected Set<Client> clientSet;
    protected Routine routine;

    public Trainer(TrainerID entityId, Routine routine) {
        super(entityId);
        appendChange(new TrainerCreated(entityId, routine)).apply();
    }

    private Trainer(TrainerID entityId) {
        super(entityId);
        subscribe(new TrainerChange(this));
    }

    public static Trainer from(TrainerID trainerID, List<DomainEvent> domainEvents) {
        Trainer trainer = new Trainer(trainerID);
        domainEvents.forEach(trainer::applyEvent);
        return trainer;
    }

    public void addClient(Client client) {
        this.clientSet.add(client);
    }

    public void removeClient(Client client) {
        this.clientSet.remove(client);
    }


}
