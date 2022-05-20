package com.zen.gymdomain.frontdesk.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;

public class AddMembership extends Command {
    private final FrontDeskID frontDeskID;
    private final Membership membership;

    public AddMembership(FrontDeskID frontDeskID, Membership membership) {
        this.frontDeskID = frontDeskID;
        this.membership = membership;
    }

    public FrontDeskID getFrontDeskID() {
        return frontDeskID;
    }

    public Membership getMembership() {
        return membership;
    }
}
