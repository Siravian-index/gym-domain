package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.Trainer;
import com.zen.gymdomain.trainer.commands.CreateTrainer;
import com.zen.gymdomain.trainer.entities.Routine;
import com.zen.gymdomain.trainer.events.TrainerCreated;
import com.zen.gymdomain.trainer.values.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreateTrainerUseCaseTest {
    private CreateTrainerUseCase useCase;

    @BeforeEach
    public void setUp() {
        useCase = new CreateTrainerUseCase();
    }

    @Test
    public void createTrainerSuccessfully() {
//        given
        TrainerID trainerID = TrainerID.of("xxxxx");
        RoutineID id = RoutineID.of("routine1");
        Description description = new Description("Some cardio for the body");
        Type type = new Type(TypeEnum.CARDIO);
        Routine routine = new Routine(id, description, type);

        CreateTrainer command = new CreateTrainer(trainerID, routine);
//        when
        List<DomainEvent> domainEvents = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

//        assert
        TrainerCreated trainerCreated = (TrainerCreated) domainEvents.get(0);
        assertEquals("xxxxx", trainerCreated.aggregateRootId());
        assertEquals("routine1", trainerCreated.getRoutine().identity().value());
        assertEquals("Some cardio for the body", trainerCreated.getRoutine().description().value());
    }

}