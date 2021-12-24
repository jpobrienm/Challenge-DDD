package co.com.sofka.challengeDDD.Delivery;

import co.com.sofka.challengeDDD.Delivery.Value.DeliveryId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Delivery extends AggregateEvent<DeliveryId> {

    public Delivery(DeliveryId deliveryId){
        super(deliveryId);
    }
}