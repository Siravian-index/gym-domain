package com.zen.gymdomain.nutritionist.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.values.NutritionistID;

import java.util.Set;

public class CreateNutritionist extends Command {
    private final NutritionistID entityId;
    private final Set<Patient> patientSet;

    public CreateNutritionist(NutritionistID entityId, Set<Patient> patientSet) {
        this.entityId = entityId;
        this.patientSet = patientSet;
    }

    public NutritionistID getEntityId() {
        return entityId;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }
}
