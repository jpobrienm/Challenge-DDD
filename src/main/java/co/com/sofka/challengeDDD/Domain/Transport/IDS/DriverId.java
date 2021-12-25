package co.com.sofka.challengeDDD.Domain.Transport.IDS;

import co.com.sofka.domain.generic.Identity;

public class DriverId extends Identity {
    private DriverId(String value){super(value);}
    public DriverId(){}
    public static DriverId of(String value){return new DriverId(value);}
}
