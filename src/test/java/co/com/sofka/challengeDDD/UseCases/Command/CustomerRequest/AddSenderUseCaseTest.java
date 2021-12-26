package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddReciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddSender;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.RecieverAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.SenderAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.RecieverId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Generics.Address;
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
class AddSenderUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addRecieverUseCaseTest(){
        // arrange
        CustomerRequestId customerRequestId = CustomerRequestId.of("xxxx");
        SenderId senderId = SenderId.of("asdsfddf");
        Name name = new Name("qwertyuiop");
        Identification identification = new Identification(12345678);

        var command = new AddSender(customerRequestId, senderId, name, identification);
        var useCase = new AddSenderUseCase();

        Mockito.when(repository.getEventsBy(senderId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(senderId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        SenderAdded event = (SenderAdded) events.get(0);

        Assertions.assertEquals(senderId.value(), event.getSenderId().value());
        Assertions.assertEquals("qwertyuiop", event.getName().value());
        Assertions.assertEquals(12345678, event.getIdentification().value());
        Mockito.verify(repository).getEventsBy(senderId.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new CustomerRequestCreated(CustomerRequestId.of("xxxx"), new MyDate(Date.from(Instant.now())))
        );
    }

}