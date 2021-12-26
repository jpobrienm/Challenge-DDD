package co.com.sofka.challengeDDD.Domain.Transport.Command;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.domain.generic.Command;

import java.util.Set;

public class CreateTransport extends Command {

    private TransportId transportId;
    private Set<DeliveryId> deliveryIdSet;

    public CreateTransport(TransportId transportId, Set<DeliveryId> deliveryIdSet){
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
