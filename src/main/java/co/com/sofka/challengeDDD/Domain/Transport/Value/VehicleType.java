package co.com.sofka.challengeDDD.Domain.Transport.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class VehicleType implements ValueObject<VehicleType.Value> {

    private final Value value;

    public VehicleType(Value value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Value value() {
        return value;
    }

    public enum Value{
        VAN,
        FURGON,
        CAMION,
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleType that = (VehicleType) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
