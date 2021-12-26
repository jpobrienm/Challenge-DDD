package co.com.sofka.challengeDDD.Domain.Delivery;

import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.domain.generic.EventChange;

public class DeliveryChange extends EventChange {

    public DeliveryChange(Delivery delivery){

        apply((DeliveryCreated event) ->{
            delivery.customerRequestId = event.getCustomerRequestId();
        });
    }
}
