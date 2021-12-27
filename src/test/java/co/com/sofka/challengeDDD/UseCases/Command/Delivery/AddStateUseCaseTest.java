package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddState;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.StateAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.StateId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.DeliveryState;
import co.com.sofka.challengeDDD.Generics.MyDate;
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
class AddStateUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addStateUseCaseTest(){
        //arrange
        DeliveryId deliveryId = DeliveryId.of("xxxx");
        StateId stateId = StateId.of("zzzz");
        DeliveryState deliveryState = new DeliveryState(DeliveryState.Value.EN_DESPACHO);
        MyDate myDate = new MyDate(Date.from(Instant.now()));

        var command = new AddState(deliveryId, stateId, deliveryState, myDate);
        var useCase = new AddStateUseCase();

        Mockito.when(repository.getEventsBy(stateId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(stateId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        StateAdded event = (StateAdded) events.get(0);

        // asserts
        Assertions.assertEquals(stateId.value(), event.getStateId().value());
        Assertions.assertEquals(deliveryState.value(), event.getDeliveryState().value());
        Assertions.assertEquals(myDate.value(), event.getMyDate().value());
        Mockito.verify(repository).getEventsBy(stateId.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new DeliveryCreated(DeliveryId.of("xxxx"), CustomerRequestId.of("yyyy"))
        );
    }

}