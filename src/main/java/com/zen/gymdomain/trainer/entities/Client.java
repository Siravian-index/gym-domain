package com.zen.gymdomain.trainer.entities;

import co.com.sofka.domain.generic.Entity;
import com.zen.gymdomain.trainer.values.ClientID;

public class Client extends Entity<ClientID> {
    public Client(ClientID entityId) {
        super(entityId);
    }
}
