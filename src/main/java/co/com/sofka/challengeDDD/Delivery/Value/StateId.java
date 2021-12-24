package co.com.sofka.challengeDDD.Delivery.Value;

import co.com.sofka.domain.generic.Identity;

public class StateId extends Identity {
    private StateId(String value){super(value);}
    public StateId(){}
    public static StateId of(String value){return new StateId(value);}
}
