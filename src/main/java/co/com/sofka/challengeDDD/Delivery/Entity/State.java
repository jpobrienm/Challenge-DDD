package co.com.sofka.challengeDDD.Delivery.Entity;

import co.com.sofka.challengeDDD.Delivery.Value.StateId;
import co.com.sofka.domain.generic.Entity;

public class State extends Entity<StateId> {

    public State(StateId stateId){
        super(stateId);
    }
}
