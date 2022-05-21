package com.zen.gymdomain.frontdesk.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.frontdesk.FrontDesk;
import com.zen.gymdomain.frontdesk.commands.UpdateMerchandiseProduct;

public class UpdateMerchandiseProductUseCase extends UseCase<RequestCommand<UpdateMerchandiseProduct>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateMerchandiseProduct> updateMerchandiseProductRequestCommand) {
        var command = updateMerchandiseProductRequestCommand.getCommand();
        FrontDesk frontDesk = FrontDesk.from(command.getFrontDeskID(), repository().getEventsBy(command.getFrontDeskID().value()));
        frontDesk.updateMerchandiseProduct(command.getMerchandiseID(), command.getProduct());
        emit().onResponse(new ResponseEvents(frontDesk.getUncommittedChanges()));

    }
}