package co.com.sofka.challengeDDD.Transport.Entity;

import co.com.sofka.challengeDDD.Transport.Value.DriverId;
import co.com.sofka.domain.generic.Entity;

public class Driver extends Entity<DriverId> {

    public Driver(DriverId driverId){
        super(driverId);
    }
}
