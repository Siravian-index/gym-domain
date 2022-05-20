package com.zen.gymdomain.trainer.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.zen.gymdomain.trainer.entities.Client;
import com.zen.gymdomain.trainer.values.FitnessLevel;
import com.zen.gymdomain.trainer.values.Name;
import com.zen.gymdomain.trainer.values.PhoneNumber;

public class ClientAdded extends DomainEvent {

    private final Name name;
    private final FitnessLevel fitnessLevel;
    private final PhoneNumber phoneNumber;

    public ClientAdded(Name name, FitnessLevel fitnessLevel, PhoneNumber phoneNumber) {
        super("com.zen.gymdomain.trainer.clientAdded");
        this.name = name;
        this.fitnessLevel = fitnessLevel;
        this.phoneNumber = phoneNumber;
    }

    public Name getName() {
        return name;
    }

    public FitnessLevel getFitnessLevel() {
        return fitnessLevel;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
