package co.com.sofka.challengeDDD.Transport.IDS;

import co.com.sofka.domain.generic.Identity;

public class VehicleId extends Identity {
    private VehicleId(String value){super(value);}
    public VehicleId(){}
    public static VehicleId of(String value){return new VehicleId(value);}
}
