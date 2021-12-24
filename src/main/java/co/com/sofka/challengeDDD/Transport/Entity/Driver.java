package co.com.sofka.challengeDDD.Transport.Entity;

import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.challengeDDD.Transport.Value.DriverId;
import co.com.sofka.challengeDDD.Transport.Value.Worktime;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Driver extends Entity<DriverId> {

    private Name name;
    private Identification identification;
    private Worktime worktime;

    public Driver(DriverId driverId, Name name, Identification identification, Worktime worktime){
        super(driverId);
        this.name = name;
        this.identification = identification;
        this.worktime = worktime;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateIdentification(Identification identification){
        this.identification = identification;
    }

    public void updateWorktime(Worktime worktime){
        this.worktime = worktime;
    }
}
