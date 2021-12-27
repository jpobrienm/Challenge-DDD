package co.com.sofka.challengeDDD.UseCases.Command.Transport;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.Command.AddDriver;
import co.com.sofka.challengeDDD.Domain.Transport.Event.DriverAdded;
import co.com.sofka.challengeDDD.Domain.Transport.Event.TransportCreated;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.DriverId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.challengeDDD.Domain.Transport.Value.Worktime;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddDriverUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDriverUseCaseTest(){
        //arrange
        TransportId transportId = TransportId.of("xxxx");
        DriverId driverId = DriverId.of("yyyy");
        Name name = new Name("fdsaaqwe");
        Identification identification = new Identification(12345678);
        Worktime worktime = new Worktime(12);

        var command = new AddDriver(transportId, driverId, name, identification, worktime);
        var useCase = new AddDriverUseCase();

        Mockito.when(repository.getEventsBy(driverId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(driverId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        DriverAdded event = (DriverAdded) events.get(0);

        // assert
        Assertions.assertEquals(driverId.value(), event.getDriverId().value());
        Assertions.assertEquals(name.value(), event.getName().value());
        Assertions.assertEquals(identification.value(), event.getIdentification().value());
        Assertions.assertEquals(worktime.value(), event.getWorktime().value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new TransportCreated(TransportId.of("xxxx"), new MyDate(Date.from(Instant.now())))
        );
    }

}