package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.UpdateSenderName;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.SenderAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.SenderNameUpdated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
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
class UpdateSenderNameUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateSenderNameUseCaseTest(){
        CustomerRequestId customerRequestId = CustomerRequestId.of("xxxx");
        SenderId senderId = SenderId.of("zzzz");
        Sender sender = new Sender(senderId, new Name("fred"), new Identification(12345668));
        Name name = new Name("paul");
        var command = new UpdateSenderName(customerRequestId, sender, name);
        var useCase = new UpdateSenderNameUseCase();

        Mockito.when(repository.getEventsBy(senderId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(senderId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        SenderNameUpdated event = (SenderNameUpdated) events.get(0);

        Assertions.assertEquals(name.value(), event.getName().value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new CustomerRequestCreated(CustomerRequestId.of("xxxx"), new MyDate(Date.from(Instant.now()))),
                new SenderAdded(SenderId.of("yyyy"), new Name("asd"), new Identification(12345678))
        );
    }

}