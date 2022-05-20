package com.zen.gymdomain.trainer.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {
    private final String value;

    public Description(String value) {
        this.value = Objects.requireNonNull(value);
    }


    @Override
    public String value() {
        return this.value;
    }
}
