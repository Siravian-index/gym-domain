package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.values.ClientID;

public class ClientRemoved extends DomainEvent {
    private final ClientID clientID;

    public ClientRemoved(ClientID clientID) {
        super("com.zen.gymdomain.trainer.clientremoved");
        this.clientID = clientID;
    }

    public ClientID getClientID() {
        return clientID;
    }
}
