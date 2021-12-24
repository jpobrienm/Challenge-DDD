package co.com.sofka.challengeDDD.Generics;

import co.com.sofka.domain.generic.ValueObject;

import javax.management.ValueExp;
import java.util.Objects;

public class Amount implements ValueObject<Integer> {
    private final Integer value;

    public Amount(Integer value){
        if(value < 0){
            throw new IllegalArgumentException("El valor no puede ser negativo");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value.equals(amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
