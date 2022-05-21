package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.RemoveMerchandise;

public class RemoveMerchandiseUseCase extends UseCase<RequestCommand<RemoveMerchandise>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemoveMerchandise> removeMerchandiseRequestCommand) {
        var command = removeMerchandiseRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.removeMerchandise(command.getMerchandiseID());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}
