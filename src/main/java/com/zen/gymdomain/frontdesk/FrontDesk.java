package com.zen.gymdomain.frontdesk;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.events.FrontDeskCreated;
import com.zen.gymdomain.frontdesk.values.FrontDeskID;
import com.zen.gymdomain.frontdesk.values.Product;

import java.util.List;
import java.util.Set;

public class FrontDesk extends AggregateEvent<FrontDeskID> {
    protected Set<Product> productSet;
    protected Set<Membership> membershipSet;
    public FrontDesk(FrontDeskID entityId, Set<Membership> membershipSet) {
        super(entityId);
        appendChange(new FrontDeskCreated(entityId, membershipSet)).apply();

    }
    private FrontDesk(FrontDeskID entityId) {
        super(entityId);
        subscribe(new FrontDeskChange(this));
    }

    public static FrontDesk from(FrontDeskID frontDeskID, List<DomainEvent> domainEvents) {
        FrontDesk frontDesk = new FrontDesk(frontDeskID);
        domainEvents.forEach(frontDesk::applyEvent);
        return frontDesk;
    }


}
