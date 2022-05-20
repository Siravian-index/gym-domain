package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.entities.Membership;

public class MembershipAdded extends DomainEvent {
    private final Membership membership;

    public MembershipAdded(Membership membership) {
        super("com.zen.gymdomain.frontdesk.memebershipadded");
        this.membership = membership;
    }

    public Membership getMembership() {
        return membership;
    }
}
