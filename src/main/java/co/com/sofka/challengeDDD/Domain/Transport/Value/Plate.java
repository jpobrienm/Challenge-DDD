package co.com.sofka.challengeDDD.Domain.Transport.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Plate implements ValueObject<String> {
    private final String value;

    public Plate(String value){
        if(!value.matches("[A-Z]{3}\\d{3}")){
            throw new IllegalArgumentException("la placa ingresada tiene un formato invalido");
        }
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plate plate = (Plate) o;
        return value.equals(plate.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
