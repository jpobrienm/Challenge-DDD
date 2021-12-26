package co.com.sofka.challengeDDD.Domain.Transport;

import co.com.sofka.challengeDDD.Domain.Transport.Entity.Driver;
import co.com.sofka.challengeDDD.Domain.Transport.Entity.Route;
import co.com.sofka.challengeDDD.Domain.Transport.Entity.Vehicle;
import co.com.sofka.challengeDDD.Domain.Transport.Event.DriverAdded;
import co.com.sofka.challengeDDD.Domain.Transport.Event.RouteAdded;
import co.com.sofka.challengeDDD.Domain.Transport.Event.TransportCreated;
import co.com.sofka.challengeDDD.Domain.Transport.Event.VehicleAdded;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class TransportChange extends EventChange {

    public TransportChange(Transport transport){

        apply((TransportCreated event)->{
            transport.transportId = event.getTransportId();
            transport.deliveryIdSet = new HashSet<>();
            transport.myDate = event.getMyDate();
        });

        apply((DriverAdded event) ->{
            transport.driver = new Driver(event.getDriverId(),
                    event.getName(),
                    event.getIdentification(),
                    event.getWorktime());
        });

        apply((VehicleAdded event) ->{
            transport.vehicle = new Vehicle(event.getVehicleId(),
                    event.getVehicleType(),
                    event.getPlate(),
                    event.getVehicleState());
        });

        apply((RouteAdded event) ->{
            transport.route = new Route(event.getRouteId(),
                    event.getOriginAddress(),
                    event.getTargetAddress());
        });
    }
}
