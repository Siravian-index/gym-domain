package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Client;

public class ClientAdded extends DomainEvent {
    private final Client client;

    public ClientAdded(Client client) {
        super("com.zen.gymdomain.trainer.clientAdded");
        this.client = client;
    }

    public Client getClient() {
        return client;
    }
}
