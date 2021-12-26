package co.com.sofka.challengeDDD.Domain.Transport.Command;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.DriverId;
import co.com.sofka.challengeDDD.Domain.Transport.Value.Worktime;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Command;

public class AddDriver extends Command {

    private final DriverId driverId;
    private final Name name;
    private final Identification identification;
    private final Worktime worktime;

    public AddDriver(DriverId driverId, Name name, Identification identification, Worktime worktime){
        this.driverId = driverId;
        this.name = name;
        this.identification = identification;
        this.worktime = worktime;
    }

    public DriverId getDriverId() {
        return driverId;
    }

    public Name getName() {
        return name;
    }

    public Identification getIdentification() {
        return identification;
    }

    public Worktime getWorktime() {
        return worktime;
    }
}
