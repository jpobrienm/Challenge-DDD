package co.com.sofka.challengeDDD.Domain.Delivery.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.Command;

public class CreateDelivery extends Command {

    private final DeliveryId deliveryId;
    private final CustomerRequestId customerRequestId;

    public CreateDelivery(DeliveryId deliveryId, CustomerRequestId customerRequestId){
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
