package co.com.sofka.challengeDDD.Generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Address implements ValueObject<Address.Properties> {

    private final String city;
    private final String street;
    private final String avenue;
    private final String number;

    public Address(String city, String street, String avenue, String number){

        if (!city.matches("^[\\p{L} .'-]+$")){
            throw new IllegalArgumentException("la ciudad es invalida");
        }
        if (!street.matches("\\d{1,3}[a-zA-Z]{0,1}")){
            throw new IllegalArgumentException("formato de calle invalido");
        }
        if (!avenue.matches("\\d{1,3}[a-zA-Z]{0,1}")){
            throw new IllegalArgumentException("formato de calle invalida");
        }
        if (!number.matches("\\d{1,3}[a-zA-Z]{0,1}")){
            throw new IllegalArgumentException("formato de numero inicial invalido");
        }

        this.city = Objects.requireNonNull(city);
        this.street = Objects.requireNonNull(street);
        this.avenue = Objects.requireNonNull(avenue);
        this.number = Objects.requireNonNull(number);
    }


    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String city() {
                return city;
            }

            @Override
            public String street() {
                return street;
            }

            @Override
            public String avenue() {
                return avenue;
            }

            @Override
            public String number() {
                return number;
            }
        };
    }

    public interface Properties {
        String city();
        String street();
        String avenue();
        String number();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return city.equals(address.city) && street.equals(address.street) && avenue.equals(address.avenue) && number.equals(address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, avenue, number);
    }
}
