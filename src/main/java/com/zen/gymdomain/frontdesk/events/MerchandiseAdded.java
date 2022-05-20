package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.entities.Merchandise;

public class MerchandiseAdded extends DomainEvent {
    private final Merchandise merchandise;

    public MerchandiseAdded(Merchandise merchandise) {
        super("com.zen.gymdomain.frontdesk.merchandiseadded");
        this.merchandise = merchandise;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }
}
