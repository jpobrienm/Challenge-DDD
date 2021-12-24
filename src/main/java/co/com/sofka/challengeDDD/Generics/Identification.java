package co.com.sofka.challengeDDD.Generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Identification implements ValueObject<Integer> {

    private final Integer identificationNumber;

    public Identification(Integer identification){
        if(identification.toString().length() != 8 && identification.toString().length() != 10
                || !identification.toString().matches("[0-9]*")){
            throw new IllegalArgumentException("El numero de identificacion no es valido");
        }
        this.identificationNumber = Objects.requireNonNull(identification);
    }

    public Integer value(){
        return identificationNumber;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Identification that = (Identification) object;
        return Objects.equals(identificationNumber, that.identificationNumber);
    }

    @Override
    public int hashCode(){
        return Objects.hash(identificationNumber);
    }
}
