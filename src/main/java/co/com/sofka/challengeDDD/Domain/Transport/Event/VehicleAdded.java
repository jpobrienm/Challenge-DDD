package co.com.sofka.challengeDDD.Domain.Transport.Event;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.VehicleId;
import co.com.sofka.challengeDDD.Domain.Transport.Value.Plate;
import co.com.sofka.challengeDDD.Domain.Transport.Value.VehicleState;
import co.com.sofka.challengeDDD.Domain.Transport.Value.VehicleType;
import co.com.sofka.domain.generic.DomainEvent;

public class VehicleAdded extends DomainEvent {

    private VehicleId vehicleId;
    private VehicleType vehicleType;
    private Plate plate;
    private VehicleState vehicleState;

    public VehicleAdded(VehicleId vehicleId, VehicleType vehicleType, Plate plate, VehicleState vehicleState){
        super("co.com.sofka.challengeDDD.vehicleAdded");
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.plate = plate;
        this.vehicleState = vehicleState;
    }

    public VehicleId getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Plate getPlate() {
        return plate;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }
}
