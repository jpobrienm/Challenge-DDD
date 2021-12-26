package co.com.sofka.challengeDDD.Domain.Transport.Event;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.RouteId;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.domain.generic.DomainEvent;

public class RouteAdded extends DomainEvent {

    private RouteId routeId;
    private Address originAddress;
    private Address targetAddress;

    public RouteAdded(RouteId routeId, Address originAddress, Address targetAddress){
        super("co.com.sofka.challengeDDD.routeAdded");
        this.routeId = routeId;
        this.originAddress = originAddress;
        this.targetAddress = targetAddress;
    }

    public RouteId getRouteId() {
        return routeId;
    }

    public Address getOriginAddress() {
        return originAddress;
    }

    public Address getTargetAddress() {
        return targetAddress;
    }
}
