package co.com.sofka.challengeDDD.Domain.Delivery.Event;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.domain.generic.DomainEvent;

public class DeliveryCreated extends DomainEvent {

    private final DeliveryId deliveryId;
    private final CustomerRequestId customerRequestId;

    public DeliveryCreated(DeliveryId deliveryId, CustomerRequestId customerRequestId){
        super("co.com.sofka.challengeDDD.deliveryCreated");
        this.deliveryId = deliveryId;
        this.customerRequestId = customerRequestId;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
    }

    public CustomerRequestId getCustomerRequestId() {
        return customerRequestId;
    }
}
