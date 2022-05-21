package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.commands.UpdateDietDescription;

public class UpdateDietDescriptionUseCase extends UseCase<RequestCommand<UpdateDietDescription>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDietDescription> updateDietDescriptionRequestCommand) {
        var command = updateDietDescriptionRequestCommand.getCommand();
        Nutritionist nutritionist = Nutritionist.from(command.getNutritionistID(), repository().getEventsBy(command.getNutritionistID().value()));
        nutritionist.updateDietDescription(command.getPatientID(), command.getDescription());
        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));

    }
}
