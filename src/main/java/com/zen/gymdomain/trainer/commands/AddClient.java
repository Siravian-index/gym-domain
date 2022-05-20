package com.zen.gymdomain.trainer.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.values.TrainerID;

public class AddClient extends Command {
    private final TrainerID trainerID;
    private final Client client;

    public AddClient(TrainerID trainerID, Client client) {
        this.trainerID = trainerID;
        this.client = client;
    }

    public TrainerID getTrainerID() {
        return trainerID;
    }

    public Client getClient() {
        return client;
    }
}
