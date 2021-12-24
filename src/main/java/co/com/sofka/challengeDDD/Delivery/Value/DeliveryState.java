package co.com.sofka.challengeDDD.Delivery.Value;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DeliveryState implements ValueObject<DeliveryState.Value> {

    private final Value value;

    public DeliveryState(Value value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Value value() {
        return value;
    }

    public enum Value{
        RECIBIDO,
        EN_BODEGA_ORIGEN,
        EN_TRAYECTO_A_CIUDAD_DESTINO,
        EN_BODEGA_DESTINO,
        EN_DESPACHO,
        ENTREGADO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryState that = (DeliveryState) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
