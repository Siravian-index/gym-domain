package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.AddMerchandise;

public class AddMerchandiseUseCase extends UseCase<RequestCommand<AddMerchandise>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddMerchandise> addMerchandiseRequestCommand) {
        var command = addMerchandiseRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.addMerchandise(command.getProduct(), command.getPrice());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}