package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.UpdateMembershipPrice;

public class UpdateMemershipPriceUseCase extends UseCase<RequestCommand<UpdateMembershipPrice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMembershipPrice> updateMembershipPriceRequestCommand) {
        var command = updateMembershipPriceRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.updateMembershipPrice(command.getMembershipID(), command.getPrice());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}