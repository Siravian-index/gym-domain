package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Routine;

public class RoutineAdded extends DomainEvent {
    private final Routine routine;

    public RoutineAdded(Routine routine) {
        super("com.zen.gymdomain.trainer.routineadded");
        this.routine = routine;
    }

    public Routine getRoutine() {
        return routine;
    }
}
