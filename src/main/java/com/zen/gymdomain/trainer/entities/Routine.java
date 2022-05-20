package com.zen.gymdomain.trainer.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.trainer.values.RoutineID;

public class Routine extends Entity<RoutineID> {

    public Routine(RoutineID entityId) {
        super(entityId);
    }
}
