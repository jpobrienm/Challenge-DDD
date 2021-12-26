package co.com.sofka.challengeDDD.Domain.Delivery;

import co.com.sofka.challengeDDD.Domain.Delivery.Entity.Bill;
import co.com.sofka.challengeDDD.Domain.Delivery.Entity.State;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.BillAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.StateAdded;
import co.com.sofka.domain.generic.EventChange;

public class DeliveryChange extends EventChange {

    public DeliveryChange(Delivery delivery){

        apply((DeliveryCreated event) ->{
            delivery.customerRequestId = event.getCustomerRequestId();
        });

        apply((BillAdded event) -> {
            delivery.bill = new Bill(event.getBillId(),
                    event.getAmount(),
                    event.getMyDate());
        });

        apply((StateAdded event) ->{
            delivery.state = new State(event.getStateId(),
                    event.getDeliveryState(),
                    event.getMyDate());
        });

        apply();
    }
}
