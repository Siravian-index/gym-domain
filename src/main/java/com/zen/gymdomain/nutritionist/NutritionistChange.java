package com.zen.gymdomain.nutritionist;

import co.com.sofka.domain.generic.EventChange;
import com.zen.gymdomain.nutritionist.events.NutritionistCreated;

import java.util.HashMap;

public class NutritionistChange extends EventChange {
    public NutritionistChange(Nutritionist nutritionist) {
        apply((NutritionistCreated event) -> {
            nutritionist.patientSet = event.getPatientSet();
            nutritionist.dietMap = new HashMap<>();
        });
    }
}
