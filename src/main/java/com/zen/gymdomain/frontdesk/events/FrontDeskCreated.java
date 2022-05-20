package com.zen.gymdomain.frontdesk.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;

import java.util.Set;

public class FrontDeskCreated extends DomainEvent {
    private final FrontDeskID frontDeskID;
    private final Set<Membership> membershipSet;

    public FrontDeskCreated(FrontDeskID frontDeskID, Set<Membership> membershipSet) {
        super("com.zen.gymdomain.frontdesk.frontdeskcreated");
        this.frontDeskID = frontDeskID;
        this.membershipSet = membershipSet;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public Set<Membership> getMembershipSet() {
        return membershipSet;
    }

//    events

}
