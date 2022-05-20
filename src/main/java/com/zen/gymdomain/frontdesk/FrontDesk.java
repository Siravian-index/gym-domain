package com.zen.gymdomain.frontdesk;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.entities.Merchandise;
import com.zen.gymdomain.frontdesk.events.*;
import com.zen.gymdomain.frontdesk.values.*;

import java.util.List;
import java.util.Set;

public class FrontDesk extends AggregateEvent<FrontDeskID> {
    protected Set<Merchandise> merchandiseSet;
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

//    events
    public void addMembership(Membership membership) {
        appendChange(new MembershipAdded(membership)).apply();
    }

    public void removeMembership(MembershipID membershipID) {
        appendChange(new MembershipRemoved(membershipID)).apply();
    }

    public void updateMembershipTier(MembershipID membershipID, Tier tier) {
        appendChange(new MembershipTierUpdated(membershipID, tier)).apply();
    }

    public void updateMembershipPrice(MembershipID membershipID, Price price) {
        appendChange(new MembershipPriceUpdated(membershipID, price)).apply();
    }

    public void addMerchandise(Merchandise merchandise) {
        appendChange(new MerchandiseAdded(merchandise)).apply();
    }

    public void removeMerchandise(MerchandiseID merchandiseID) {
        appendChange(new MerchandiseRemoved(merchandiseID)).apply();
    }
}
