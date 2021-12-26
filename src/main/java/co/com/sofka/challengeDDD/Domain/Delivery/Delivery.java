package co.com.sofka.challengeDDD.Domain.Delivery;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Entity.Bill;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.DeliveryState;
import co.com.sofka.domain.generic.AggregateEvent;

public class Delivery extends AggregateEvent<DeliveryId> {

    protected CustomerRequestId customerRequestId;
    protected Bill bill;
    protected DeliveryState deliveryState;
    protected Package aPackage;

    public Delivery(DeliveryId deliveryId, CustomerRequestId customerRequestId){
        super(deliveryId);
        this.customerRequestId = customerRequestId;
        appendChange(new DeliveryCreated(deliveryId, customerRequestId));
    }

    private Delivery(DeliveryId deliveryId){
        super(deliveryId);
        subscribe(new DeliveryChange(this));
    }
}
