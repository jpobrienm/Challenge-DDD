package co.com.sofka.challengeDDD.UseCases.Event;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;

import java.util.List;

public class DeliveryCreatedUseCase extends UseCase<TriggeredEvent<DeliveryCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<DeliveryCreated> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var service = getService(GenerateDeliveryLog.class).orElseThrow();
        boolean isGenerated = service.generate(DeliveryId.of(event.aggregateRootId()),
                "Entrega generada exitosamente");
        if(!isGenerated){
            throw new BusinessException(event.aggregateRootId(), "No se pudo generar entrega");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
