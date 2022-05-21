package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.UpdateMembershipTier;

public class UpdateMembershipTierUseCase extends UseCase<RequestCommand<UpdateMembershipTier>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateMembershipTier> updateMembershipTierRequestCommand) {
        var command = updateMembershipTierRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.updateMembershipTier(command.getMembershipID(), command.getTier());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}
