package co.com.sofka.challengeDDD.Domain.Transport.Event;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class TransportCreated extends DomainEvent {

    private final TransportId transportId;
    private final MyDate myDate;

    public TransportCreated(TransportId transportId, MyDate myDate){
        super("co.com.sofka.challengeDDD.transportCreated");
        this.transportId = transportId;
        this.myDate = myDate;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public MyDate getMyDate() {
        return myDate;
    }
}
