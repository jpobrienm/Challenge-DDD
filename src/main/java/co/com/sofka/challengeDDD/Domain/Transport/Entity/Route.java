package co.com.sofka.challengeDDD.Domain.Transport.Entity;

import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.RouteId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Route extends Entity<RouteId> {

    private Address originAddress;
    private Address targetAddress;

    public Route(RouteId routeId, Address originAddress, Address targetAddress){
        super(routeId);
        this.originAddress = originAddress;
        this.targetAddress = targetAddress;
    }

    public void updateOriginAddress(Address originAddress){
        this.originAddress = Objects.requireNonNull(originAddress);
    }

    public void updateTargetAddress(Address targetAddress){
        this.targetAddress = Objects.requireNonNull(targetAddress);
    }
}
