package co.com.sofka.challengeDDD.Domain.Delivery.Entity;

import co.com.sofka.challengeDDD.Domain.Delivery.Value.DeliveryState;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.StateId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class State extends Entity<StateId> {

    private DeliveryState deliveryState;
    private MyDate myDate;

    public State(StateId stateId, DeliveryState deliveryState, MyDate myDate){
        super(stateId);
        this.deliveryState = deliveryState;
        this.myDate = myDate;
    }

    private void updateDeliveryState(DeliveryState deliveryState){
        this.deliveryState = Objects.requireNonNull(deliveryState);
    }

    private void updateMyDate(MyDate myDate){
        this.myDate = myDate;
    }
}
