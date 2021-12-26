package co.com.sofka.challengeDDD.Domain.Delivery.Command;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.StateId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.DeliveryState;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.Command;

public class AddState extends Command {
    private final StateId stateId;
    private final DeliveryState deliveryState;
    private final MyDate myDate;

    public AddState(StateId stateId, DeliveryState deliveryState, MyDate myDate){
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
