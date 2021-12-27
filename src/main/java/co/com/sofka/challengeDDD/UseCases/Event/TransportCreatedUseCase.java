package co.com.sofka.challengeDDD.UseCases.Event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.Event.TransportCreated;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;

import java.util.List;

public class TransportCreatedUseCase extends UseCase<TriggeredEvent<TransportCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<TransportCreated> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var service = getService(GenerateTransportLog.class).orElseThrow();
        boolean isGenerated = service.generate(TransportId.of(event.aggregateRootId()),
                "Transporte generado exitosamente");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo generar transporte");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
