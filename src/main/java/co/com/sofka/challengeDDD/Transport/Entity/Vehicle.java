package co.com.sofka.challengeDDD.Transport.Entity;

import co.com.sofka.challengeDDD.Transport.Value.Plate;
import co.com.sofka.challengeDDD.Transport.IDS.VehicleId;
import co.com.sofka.challengeDDD.Transport.Value.VehicleState;
import co.com.sofka.challengeDDD.Transport.Value.VehicleType;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Vehicle extends Entity<VehicleId> {

    private VehicleType vehicleType;
    private Plate plate;
    private VehicleState vehicleState;

    public Vehicle(VehicleId vehicleId, VehicleType vehicleType, Plate plate, VehicleState vehicleState){
        super(vehicleId);
        this.vehicleType = vehicleType;
        this.plate = plate;
        this.vehicleState = vehicleState;
    }

    public void updateVehicleType(VehicleType vehicleType){
        this.vehicleType = Objects.requireNonNull(vehicleType);
    }

    public void updatePlate(Plate plate){
        this.plate = Objects.requireNonNull(plate);
    }

    public void updateVehicleState(VehicleState vehicleState){
        this.vehicleState = Objects.requireNonNull(vehicleState);
    }
}
