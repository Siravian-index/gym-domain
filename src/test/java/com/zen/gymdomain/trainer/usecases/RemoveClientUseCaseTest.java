package com.zen.gymdomain.trainer.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.commands.RemoveClient;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.events.ClientRemoved;
import com.zen.gymdomain.trainer.events.TrainerCreated;
import com.zen.gymdomain.trainer.values.ClientID;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.TrainerID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RemoveClientUseCaseTest {

    @InjectMocks
    private RemoveClientUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void removeClientFromTrainerSuccessfully() {
//        given
        TrainerID trainerID = TrainerID.of("fakeTrainerID");
        ClientID clientID = ClientID.of("fakeClientID");
        var command = new RemoveClient(trainerID, clientID);

        when(repository.getEventsBy("fakeTrainerID")).thenReturn(history());
        useCase.addRepository(repository);
//        when
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTrainerID().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
//        assert
        var event = (ClientRemoved) events.get(0);
        assertEquals(event.getClientID().value(), clientID.value());
        assertEquals(event.getClientID(), clientID);
    }


    private List<DomainEvent> history() {
        TrainerID trainerID = TrainerID.of("fakeTrainerID");
        Name name = new Name("Juan");
        var event = new TrainerCreated(name);
        event.setAggregateRootId(trainerID.value());
        return List.of(event);
    }
}
