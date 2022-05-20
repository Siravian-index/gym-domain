package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FitnessLevel implements ValueObject<FitnessLevelEnum> {
    private final FitnessLevelEnum value;

    public FitnessLevel(FitnessLevelEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public FitnessLevelEnum value() {
        return this.value;
    }
}

enum FitnessLevelEnum {
    LOW, MEDIUM, HIGH
}
