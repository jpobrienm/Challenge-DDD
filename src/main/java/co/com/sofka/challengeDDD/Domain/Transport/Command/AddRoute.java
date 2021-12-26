package co.com.sofka.challengeDDD.Domain.Transport.Command;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.RouteId;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.domain.generic.Command;

public class AddRoute extends Command {

    private RouteId routeId;
    private Address originAddress;
    private Address targetAddress;

    public AddRoute(RouteId routeId, Address originAddress, Address targetAddress){
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
