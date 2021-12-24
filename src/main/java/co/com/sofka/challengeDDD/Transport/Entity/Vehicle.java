package co.com.sofka.challengeDDD.Transport.Entity;

import co.com.sofka.challengeDDD.Transport.Value.VehicleId;
import co.com.sofka.domain.generic.Entity;

public class Vehicle extends Entity<VehicleId> {

    public Vehicle(VehicleId vehicleId){
        super(vehicleId);
    }
}
