package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.commands.RemovePatient;

public class RemovePatientUseCase extends UseCase<RequestCommand<RemovePatient>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<RemovePatient> removePatientRequestCommand) {
        var command = removePatientRequestCommand.getCommand();
        Nutritionist nutritionist = Nutritionist.from(command.getNutritionistID(), repository().getEventsBy(command.getNutritionistID().value()));
        nutritionist.removePatient(command.getPatientID());
        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));

    }
}
