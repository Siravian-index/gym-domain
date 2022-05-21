package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.commands.AddPatient;

public class AddPatientUseCase extends UseCase<RequestCommand<AddPatient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddPatient> addPatientRequestCommand) {
        var command = addPatientRequestCommand.getCommand();
        Nutritionist nutritionist = Nutritionist.from(command.getNutritionistID(), repository().getEventsBy(command.getNutritionistID().value()));
        nutritionist.addPatient(command.getName(), command.getWeightStatus(), command.getDietType(), command.getDescription());
        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));

    }
}
