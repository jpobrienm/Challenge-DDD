package co.com.sofka.challengeDDD.CustomerRequest.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Category implements ValueObject<Category.Value> {

    private final Value value;

    public Category(Value value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Value value() {
        return value;
    }

    public enum Value{
        ELECTRONICA,
        TEXTIL,
        DELICADO,
        PERECEDERO,
        VALIOSO,
        EXPRESS
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return value == category.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
