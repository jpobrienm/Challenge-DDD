package co.com.sofka.challengeDDD.UseCases.Event;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;

public interface GenerateDeliveryLog {
    boolean generate(DeliveryId deliveryId, String log);
}
