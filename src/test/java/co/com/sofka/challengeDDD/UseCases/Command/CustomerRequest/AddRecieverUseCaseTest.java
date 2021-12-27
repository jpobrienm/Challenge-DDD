package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddReciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.RecieverAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.RecieverId;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventChange;
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
class AddRecieverUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addRecieverUseCaseTest(){
        // arrange
        CustomerRequestId customerRequestId = CustomerRequestId.of("xxxx");
        RecieverId recieverId = RecieverId.of("asdsfddf");
        Name name = new Name("qwertyuiop");
        Identification identification = new Identification(12345678);
        Address address = new Address("Bogota", "15", "15", "32");

        var command = new AddReciever(customerRequestId, recieverId, name, identification, address);
        var useCase = new AddRecieverUseCase();

        Mockito.when(repository.getEventsBy(recieverId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(recieverId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        RecieverAdded event = (RecieverAdded) events.get(0);

        // assert
        Assertions.assertEquals(recieverId.value(), event.getRecieverId().value());
        Assertions.assertEquals("qwertyuiop", event.getName().value());
        Assertions.assertEquals(12345678, event.getIdentification().value());
        Assertions.assertEquals(address.value().city(), event.getAddress().value().city());
        Assertions.assertEquals(address.value().street(), event.getAddress().value().street());
        Assertions.assertEquals(address.value().avenue(), event.getAddress().value().avenue());
        Assertions.assertEquals(address.value().number(), event.getAddress().value().number());
        Mockito.verify(repository).getEventsBy(recieverId.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new CustomerRequestCreated(CustomerRequestId.of("xxxx"), new MyDate(Date.from(Instant.now())))
        );
    }
}