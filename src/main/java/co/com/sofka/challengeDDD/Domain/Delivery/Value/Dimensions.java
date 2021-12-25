package co.com.sofka.challengeDDD.Domain.Delivery.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Dimensions implements ValueObject<Dimensions.Properties> {

    private final Double width;
    private final Double length;
    private final Double height;

    public Dimensions(Double width, Double length, Double height){
        if(width <= 0 || length <= 0 || height <= 0){
            throw new IllegalArgumentException("Las dimensiones deben ser todas positivas");
        }
        this.width = Objects.requireNonNull(width);
        this.length = Objects.requireNonNull(length);
        this.height = Objects.requireNonNull(height);
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public Double width() {
                return width;
            }

            @Override
            public Double length() {
                return length;
            }

            @Override
            public Double height() {
                return height;
            }
        };
    }

    public interface Properties{
        Double width();
        Double length();
        Double height();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dimensions that = (Dimensions) o;
        return width.equals(that.width) && length.equals(that.length) && height.equals(that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, height);
    }
}
