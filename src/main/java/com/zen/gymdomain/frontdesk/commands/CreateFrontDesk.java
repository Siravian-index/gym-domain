package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;

import java.util.Set;

public class CreateFrontDesk extends Command {

    private final FrontDeskID entityId;
    private final Set<Membership> membershipSet;

    public CreateFrontDesk(FrontDeskID entityId, Set<Membership> membershipSet) {
        this.entityId = entityId;
        this.membershipSet = membershipSet;
    }

    public FrontDeskID getEntityId() {
        return entityId;
    }

    public Set<Membership> getMembershipSet() {
        return membershipSet;
    }
}
