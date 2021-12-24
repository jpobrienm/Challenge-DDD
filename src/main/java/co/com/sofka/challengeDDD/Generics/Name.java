package co.com.sofka.challengeDDD.Generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String name;

    public Name(String name){
        if (!name.matches("^[\\p{L} .'-]+$")){
            throw new IllegalArgumentException("El nombre debe contener solo letras");
        }
        this.name = Objects.requireNonNull(name);
    }

    public String value(){
        return name;
    }

    @Override
    public boolean equals(Object object){
        if(this == object) return true;
        if(object == null || getClass() != object.getClass()) return false;
        Name that = (Name) object;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
