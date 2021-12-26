package co.com.sofka.challengeDDD.UseCases.Command.Transport;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.Command.CreateTransport;
import co.com.sofka.challengeDDD.Domain.Transport.Event.TransportCreated;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CreateTransportUseCaseTest {

    @Test
    void createTransportUseCaseTest(){
        // arrange
        TransportId transportId = TransportId.of("xxxx");
        MyDate myDate = new MyDate(Date.from(Instant.now()));

        var command = new CreateTransport(transportId, myDate);
        var useCase = new CreateTransportUseCase();

        // act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        // assert

        var event = (TransportCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(myDate.value(), event.getMyDate().value());
    }

}