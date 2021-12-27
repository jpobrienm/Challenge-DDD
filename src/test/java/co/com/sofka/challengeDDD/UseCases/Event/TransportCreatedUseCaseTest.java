package co.com.sofka.challengeDDD.UseCases.Event;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.Event.TransportCreated;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransportCreatedUseCaseTest {

    @Mock
    GenerateTransportLog service;

    @Test
    void transportCreatedUseCaseTest(){
        TransportId transportId = TransportId.of("xxxx");
        MyDate myDate = new MyDate(Date.from(Instant.now()));

        var event = new TransportCreated(transportId, myDate);
        event.setAggregateRootId(transportId.value());
        var useCase = new TransportCreatedUseCase();

        when(service.generate(transportId, "Transporte generado exitosamente")).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(service);
        useCase.addServiceBuilder(builder);

        UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(service).generate(transportId, "Transporte generado exitosamente");

    }

}