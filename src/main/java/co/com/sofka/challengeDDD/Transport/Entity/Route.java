package co.com.sofka.challengeDDD.Transport.Entity;

import co.com.sofka.challengeDDD.Transport.Value.RouteId;
import co.com.sofka.domain.generic.Entity;

public class Route extends Entity<RouteId> {

    public Route(RouteId routeId){
        super(routeId);
    }
}
