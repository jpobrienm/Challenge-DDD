package co.com.sofka.challengeDDD.Delivery.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Date;
import java.util.Objects;

public class MyDate implements ValueObject<Date> {
    private final Date date;

    public MyDate(Date date){
        this.date = Objects.requireNonNull(date);
    }

    @Override
    public Date value() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate that = (MyDate) o;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }
}
