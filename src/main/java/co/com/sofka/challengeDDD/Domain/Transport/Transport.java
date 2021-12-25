package co.com.sofka.challengeDDD.Domain.Transport;

import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Transport extends AggregateEvent<TransportId> {

    public Transport(TransportId transportId){
        super(transportId);
    }
}
