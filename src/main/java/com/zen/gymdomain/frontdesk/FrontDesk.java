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
    public FrontDesk(FrontDeskID entityId, Set<Membership> membershipSet) { //change this
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
    public void addMembership(Membership membership) { //change this
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

    public void addMerchandise(Merchandise merchandise) { //change this
        appendChange(new MerchandiseAdded(merchandise)).apply();
    }

    public void removeMerchandise(MerchandiseID merchandiseID) {
        appendChange(new MerchandiseRemoved(merchandiseID)).apply();
    }

    public void updateMerchandiseProduct(MerchandiseID merchandiseID, Product product) {
        appendChange(new MerchandiseProductUpdated(merchandiseID, product)).apply();
    }

    public void updateMerchandisePrice(MerchandiseID merchandiseID, Price price) {
        appendChange(new MerchandisePriceUpdated(merchandiseID, price)).apply();
    }
}
