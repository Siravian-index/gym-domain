package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.UpdateMerchandisePrice;

public class UpdateMerchandisePriceUseCase extends UseCase<RequestCommand<UpdateMerchandisePrice>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMerchandisePrice> updateMerchandisePriceRequestCommand) {
        var command = updateMerchandisePriceRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.updateMerchandisePrice(command.getMerchandiseID(), command.getPrice());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));
    }
}
