package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.commands.UpdateDietType;

public class UpdateDietTypeUseCase extends UseCase<RequestCommand<UpdateDietType>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDietType> updateDietTypeRequestCommand) {
        var command = updateDietTypeRequestCommand.getCommand();
        Nutritionist nutritionist = Nutritionist.from(command.getNutritionistID(), repository().getEventsBy(command.getNutritionistID().value()));
        nutritionist.updateDietType(command.getPatientID(), command.getDietType());
        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));

    }
}
