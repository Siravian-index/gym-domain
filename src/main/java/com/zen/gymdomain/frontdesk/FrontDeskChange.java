package com.zen.gymdomain.frontdesk;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.frontdesk.events.FrontDeskCreated;

import java.util.HashSet;

public class FrontDeskChange extends EventChange {

    public FrontDeskChange(FrontDesk frontDesk) {
        apply((FrontDeskCreated event) -> {
            frontDesk.membershipSet = event.getMembershipSet();
            frontDesk.productSet = new HashSet<>();
        });
    }
}
