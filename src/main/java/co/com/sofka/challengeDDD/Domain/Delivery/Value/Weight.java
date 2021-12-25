package co.com.sofka.challengeDDD.Domain.Delivery.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Weight implements ValueObject<Double> {
    private final Double value;

    public Weight(Double value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return value.equals(weight.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
