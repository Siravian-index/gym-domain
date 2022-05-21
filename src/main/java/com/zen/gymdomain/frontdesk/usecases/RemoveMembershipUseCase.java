package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.RemoveMembership;

public class RemoveMembershipUseCase extends UseCase<RequestCommand<RemoveMembership>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<RemoveMembership> removeMembershipRequestCommand) {
        var command = removeMembershipRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.removeMembership(command.getMembershipID());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}
