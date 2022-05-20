package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<TypeEnum> {
    private final TypeEnum value;

    public Type(TypeEnum value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public TypeEnum value() {
        return this.value;
    }
}
