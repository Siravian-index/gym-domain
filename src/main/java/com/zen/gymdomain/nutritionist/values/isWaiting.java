package com.zen.gymdomain.nutritionist.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class isWaiting implements ValueObject<Boolean> {
    private final Boolean value;

    public isWaiting(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Boolean value() {
        return this.value;
    }
}
