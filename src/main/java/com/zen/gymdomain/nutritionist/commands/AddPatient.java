package com.zen.gymdomain.nutritionist.commands;

import co.com.sofka.domain.generic.Command;
import com.zen.gymdomain.nutritionist.entities.Diet;
import com.zen.gymdomain.nutritionist.entities.Patient;
import com.zen.gymdomain.nutritionist.values.NutritionistID;

public class AddPatient extends Command {
    private final NutritionistID nutritionistID;
    private final Patient patient;
    private final Diet diet;

    public AddPatient(NutritionistID nutritionistID, Patient patient, Diet diet) {
        this.nutritionistID = nutritionistID;
        this.patient = patient;
        this.diet = diet;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diet getDiet() {
        return diet;
    }

    public NutritionistID getNutritionistID() {
        return nutritionistID;
    }
}
