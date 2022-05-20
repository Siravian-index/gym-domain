package com.zen.gymdomain.nutritionist.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.nutritionist.entities.Diet;
import com.zen.gymdomain.nutritionist.entities.Patient;

public class PatientAdded extends DomainEvent {
    private final Patient patient;
    private final Diet diet;

    public PatientAdded(Patient patient, Diet diet) {
        super("com.zen.gymdomain.nutritionist.patientadded");
        this.patient = patient;
        this.diet = diet;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diet getDiet() {
        return diet;
    }
}
