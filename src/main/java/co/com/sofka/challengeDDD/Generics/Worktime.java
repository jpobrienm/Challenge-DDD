package co.com.sofka.challengeDDD.Generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Worktime implements ValueObject<Integer> {

    private Integer value;

    public Worktime(Integer value){
        if(value < 0){
            throw new IllegalArgumentException("el numero de horas de trabajo no puede ser negativo");
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
        Worktime worktime = (Worktime) o;
        return value.equals(worktime.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
