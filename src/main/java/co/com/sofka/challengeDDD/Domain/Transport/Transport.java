package co.com.sofka.challengeDDD.Domain.Transport;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.Command.AddVehicle;
import co.com.sofka.challengeDDD.Domain.Transport.Entity.Driver;
import co.com.sofka.challengeDDD.Domain.Transport.Entity.Route;
import co.com.sofka.challengeDDD.Domain.Transport.Entity.Vehicle;
import co.com.sofka.challengeDDD.Domain.Transport.Event.DriverAdded;
import co.com.sofka.challengeDDD.Domain.Transport.Event.RouteAdded;
import co.com.sofka.challengeDDD.Domain.Transport.Event.TransportCreated;
import co.com.sofka.challengeDDD.Domain.Transport.Event.VehicleAdded;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.DriverId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.RouteId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.VehicleId;
import co.com.sofka.challengeDDD.Domain.Transport.Value.Plate;
import co.com.sofka.challengeDDD.Domain.Transport.Value.VehicleState;
import co.com.sofka.challengeDDD.Domain.Transport.Value.VehicleType;
import co.com.sofka.challengeDDD.Domain.Transport.Value.Worktime;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.io.ObjectStreamException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Transport extends AggregateEvent<TransportId> {

    protected TransportId transportId;
    protected Set<DeliveryId> deliveryIdSet;
    protected Driver driver;
    protected Vehicle vehicle;
    protected Route route;
    protected MyDate myDate;

    public Transport(TransportId transportId, MyDate myDate){
        super(transportId);
        this.myDate = myDate;
        appendChange(new TransportCreated(transportId, myDate)).apply();
    }

    private Transport(TransportId transportId){
        super(transportId);
        subscribe(new TransportChange(this));
    }

    public static Transport from(TransportId transportId, List<DomainEvent> events){
        var transport = new Transport(transportId);
        events.forEach(transport::applyEvent);
        return transport;
    }

    public void addDriver(DriverId driverId, Name name, Identification identification, Worktime worktime){
        Objects.requireNonNull(driverId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(identification);
        Objects.requireNonNull(worktime);
        appendChange(new DriverAdded(driverId, name, identification, worktime)).apply();
    }

    public void addVehicle(VehicleId vehicleId, VehicleType vehicleType, Plate plate, VehicleState vehicleState){
        Objects.requireNonNull(vehicleId);
        Objects.requireNonNull(vehicleType);
        Objects.requireNonNull(plate);
        Objects.requireNonNull(vehicleState);
        appendChange(new VehicleAdded(vehicleId, vehicleType, plate, vehicleState)).apply();
    }

    public void addRoute(RouteId routeId, Address originAddress, Address targetAddfress){
        Objects.requireNonNull(routeId);
        Objects.requireNonNull(originAddress);
        Objects.requireNonNull(targetAddfress);
        appendChange(new RouteAdded(routeId, originAddress, targetAddfress)).apply();
    }

    public TransportId transportId() {
        return transportId;
    }

    public Set<DeliveryId> deliveryIdSet() {
        return deliveryIdSet;
    }

    public Driver driver() {
        return driver;
    }

    public Vehicle vehicle() {
        return vehicle;
    }

    public Route route() {
        return route;
    }

    public MyDate myDate() {
        return myDate;
    }
}
