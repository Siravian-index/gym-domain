package com.zen.gymdomain.nutritionist.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.zen.gymdomain.nutritionist.Nutritionist;
import com.zen.gymdomain.nutritionist.commands.UpdatePatientWeightStatus;

public class UpdatePatientWeightStatusUseCase extends UseCase<RequestCommand<UpdatePatientWeightStatus>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdatePatientWeightStatus> updatePatientWeightStatusRequestCommand) {
        var command = updatePatientWeightStatusRequestCommand.getCommand();
        Nutritionist nutritionist = Nutritionist.from(command.getNutritionistID(), repository().getEventsBy(command.getNutritionistID().value()));

        nutritionist.updatePatientWeightStatus(command.getPatientID(), command.getWeightStatus());
        emit().onResponse(new ResponseEvents(nutritionist.getUncommittedChanges()));

    }
}
