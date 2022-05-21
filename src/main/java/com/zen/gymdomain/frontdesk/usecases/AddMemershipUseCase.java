package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.AddMembership;

public class AddMemershipUseCase extends UseCase<RequestCommand<AddMembership>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddMembership> addMembershipRequestCommand) {
        var command = addMembershipRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.addMembership(command.getTier(), command.getPrice());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}


