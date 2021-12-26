package co.com.sofka.challengeDDD.Domain.Transport.Event;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.Set;

public class TransportCreated extends DomainEvent {

    private TransportId transportId;
    private Set<DeliveryId> deliveryIdSet;

    public TransportCreated(TransportId transportId, Set<DeliveryId> deliveryIdSet){
        super("co.com.sofka.challengeDDD.transportCreated");
        this.transportId = transportId;
        this.deliveryIdSet = deliveryIdSet;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public Set<DeliveryId> getDeliveryIdSet() {
        return deliveryIdSet;
    }
}
