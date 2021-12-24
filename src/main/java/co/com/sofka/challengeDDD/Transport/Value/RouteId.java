package co.com.sofka.challengeDDD.Transport.Value;

import co.com.sofka.challengeDDD.Delivery.Value.StateId;
import co.com.sofka.domain.generic.Identity;

public class RouteId extends Identity {
    private RouteId(String value){super(value);}
    public RouteId(){}
    public static RouteId of(String value){return new RouteId(value);}
}
