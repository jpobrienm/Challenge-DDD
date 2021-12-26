package co.com.sofka.challengeDDD.Domain.Delivery.Event;

import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.StateId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.DeliveryState;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.DomainEvent;

public class StateAdded extends DomainEvent {

    private final StateId stateId;
    private final DeliveryState deliveryState;
    private final MyDate myDate;

    public StateAdded(StateId stateId, DeliveryState deliveryState, MyDate myDate){
        super("co.com.sofka.challengeDDD.stateAdded");
        this.stateId = stateId;
        this.deliveryState = deliveryState;
        this.myDate = myDate;
    }

    public StateId getStateId() {
        return stateId;
    }

    public DeliveryState getDeliveryState() {
        return deliveryState;
    }

    public MyDate getMyDate() {
        return myDate;
    }
}
