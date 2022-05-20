package com.zen.gymdomain.nutritionist;

import co.com.sofka.domain.generic.AggregateEvent;
import com.zen.gymdomain.nutritionist.entities.Diet;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.events.NutritionistCreated;
import com.zen.gymdomain.nutritionist.values.NutritionistID;
import com.zen.gymdomain.nutritionist.values.PatientID;

import java.util.Map;
import java.util.Set;

public class Nutritionist extends AggregateEvent<NutritionistID> {
    protected Set<Patient> patientSet;
    protected Map<PatientID, Diet> dietMap;
    public Nutritionist(NutritionistID entityId, Set<Patient> patientSet) {
        super(entityId);
        appendChange(new NutritionistCreated(entityId, patientSet));
    }

    private Nutritionist(NutritionistID entityId) {
        super(entityId);
        subscribe(new NutritionistChange(this));
    }


}
