package com.zen.gymdomain.trainer;

import co.com.sofka.domain.generic.AggregateEvent;
import com.zen.gymdomain.trainer.values.TrainerID;

public class Trainer extends AggregateEvent<TrainerID> {

    public Trainer(TrainerID entityId) {
        super(entityId);
    }
}
