package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.commands.TogglePatientIsWaiting;

public class TogglePatientIsWaitingUseCase extends UseCase<RequestCommand<TogglePatientIsWaiting>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<TogglePatientIsWaiting> togglePatientIsWaitingRequestCommand) {
        var command = togglePatientIsWaitingRequestCommand.getCommand();
        Nutritionist nutritionist = Nutritionist.from(command.getNutritionistID(), repository().getEventsBy(command.getNutritionistID().value()));
        nutritionist.togglePatientIsWaiting(command.getPatientID());
        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));

    }
}
