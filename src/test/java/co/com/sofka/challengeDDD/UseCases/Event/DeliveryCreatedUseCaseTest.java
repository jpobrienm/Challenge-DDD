package co.com.sofka.challengeDDD.UseCases.Event;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeliveryCreatedUseCaseTest {

    @Mock
    GenerateDeliveryLog service;

    @Test
    void deliveryCreatedUseCaseTest(){
        DeliveryId deliveryId = DeliveryId.of("xxxx");
        CustomerRequestId customerRequestId = CustomerRequestId.of("yyyy");

        var event = new DeliveryCreated(deliveryId, customerRequestId);
        event.setAggregateRootId(deliveryId.value());
        var useCase = new DeliveryCreatedUseCase();

        when(service.generate(deliveryId, "Entrega generada exitosamente")).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        useCase.addServiceBuilder(builder);

        UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(service).generate(deliveryId, "Entrega generada exitosamente");

    }
}