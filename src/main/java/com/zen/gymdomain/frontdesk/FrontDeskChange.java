package com.zen.gymdomain.frontdesk;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.frontdesk.entities.Membership;
import com.zen.gymdomain.frontdesk.entities.Merchandise;
import com.zen.gymdomain.frontdesk.events.*;

import java.util.HashSet;

public class FrontDeskChange extends EventChange {

    public FrontDeskChange(FrontDesk frontDesk) {
        apply((FrontDeskCreated event) -> {
            frontDesk.membershipSet = event.getMembershipSet();
            frontDesk.merchandiseSet = new HashSet<>();
        });

        apply((MembershipAdded event) -> {
            frontDesk.membershipSet.add(event.getMembership());
        });

        apply((MembershipRemoved event) -> {
            frontDesk.membershipSet.removeIf(membership -> membership.identity().equals(event.getMembershipID()));
        });

        apply((MembershipTierUpdated event) -> {
            Membership membership1 = frontDesk.membershipSet.stream().filter(membership -> membership.identity().equals(event.getMembershipID())).findFirst().orElseThrow();
            membership1.updateTier(event.getTier());
            frontDesk.membershipSet.removeIf(membership -> membership.identity().equals(event.getMembershipID()));
            frontDesk.membershipSet.add(membership1);
        });

        apply((MembershipPriceUpdated event) -> {
            Membership membership1 = frontDesk.membershipSet.stream().filter(membership -> membership.identity().equals(event.getMembershipID())).findFirst().orElseThrow();
            membership1.updatePrice(event.getPrice());
            frontDesk.membershipSet.removeIf(membership -> membership.identity().equals(event.getMembershipID()));
            frontDesk.membershipSet.add(membership1);
        });

        apply((MerchandiseAdded event) -> {
            frontDesk.merchandiseSet.add(event.getMerchandise());
        });

        apply((MerchandiseRemoved event) -> {
            frontDesk.merchandiseSet.removeIf(merchandise -> merchandise.identity().equals(event.getMerchandiseID()));
        });

        apply((MerchandiseProductUpdated event) -> {
            Merchandise merchandise1 = frontDesk.merchandiseSet.stream().filter(merchandise -> merchandise.identity().equals(event.getMerchandiseID())).findFirst().orElseThrow();
            merchandise1.updateProduct(event.getProduct());
            frontDesk.merchandiseSet.removeIf(merchandise -> merchandise.identity().equals(event.getMerchandiseID()));
            frontDesk.merchandiseSet.add(merchandise1);
        });

        apply((MerchandisePriceUpdated event) -> {
            Merchandise merchandise1 = frontDesk.merchandiseSet.stream()
                    .filter(merchandise -> merchandise.identity().equals(event.getMerchandiseID()))
                    .findFirst().orElseThrow();
            merchandise1.updatePrice(event.getPrice());
            frontDesk.merchandiseSet.removeIf(m -> m.identity().equals(event.getMerchandiseID()));
            frontDesk.merchandiseSet.add(merchandise1);
        });

    }
}
