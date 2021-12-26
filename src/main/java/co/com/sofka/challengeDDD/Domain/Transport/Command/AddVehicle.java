package co.com.sofka.challengeDDD.Domain.Transport.Command;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.VehicleId;
import co.com.sofka.challengeDDD.Domain.Transport.Value.Plate;
import co.com.sofka.challengeDDD.Domain.Transport.Value.VehicleState;
import co.com.sofka.challengeDDD.Domain.Transport.Value.VehicleType;
import co.com.sofka.domain.generic.Command;

public class AddVehicle extends Command {

    private VehicleId vehicleId;
    private VehicleType vehicleType;
    private Plate plate;
    private VehicleState vehicleState;

    public AddVehicle(VehicleId vehicleId, VehicleType vehicleType, Plate plate, VehicleState vehicleState){
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
