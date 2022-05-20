package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.values.NutritionistID;

import java.util.Set;

public class NutritionistCreated extends DomainEvent {
    private final NutritionistID entityId;
    private final Set<Patient> patientSet;

    public NutritionistCreated(NutritionistID entityId, Set<Patient> patientSet) {
        super("com.zen.gymdomain.nutritionist.nutritionistcreated");
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
