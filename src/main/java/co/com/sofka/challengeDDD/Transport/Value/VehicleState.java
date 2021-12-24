package co.com.sofka.challengeDDD.Transport.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class VehicleState implements ValueObject<VehicleState.Value> {

    private Value value;

    public VehicleState(Value value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Value value() {
        return value;
    }

    public enum Value{
        PERFECTO,
        FUNCIONAL,
        AVERIA_MENOR,
        AVERIA_MAYOR,
        AVERIA_TOTAL
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleState that = (VehicleState) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
