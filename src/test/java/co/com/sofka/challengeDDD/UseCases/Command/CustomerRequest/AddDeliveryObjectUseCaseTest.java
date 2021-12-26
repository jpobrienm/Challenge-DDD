package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddDeliveryObject;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.DeliveryObjectAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.DeliveryObjectId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Value.Category;
import co.com.sofka.challengeDDD.Generics.Amount;
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
class AddDeliveryObjectUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDeliveryObjectUseCaseTest(){

        // arrange
        CustomerRequestId customerRequestId = CustomerRequestId.of("xxxx");
        DeliveryObjectId deliveryObjectId = DeliveryObjectId.of("wwww");
        Category category = new Category(Category.Value.ELECTRONICA);
        Amount amount = new Amount(123);

        var command = new AddDeliveryObject(customerRequestId, deliveryObjectId, category, amount);
        var useCase = new AddDeliveryObjectUseCase();

        Mockito.when(repository.getEventsBy(deliveryObjectId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(deliveryObjectId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        DeliveryObjectAdded event = (DeliveryObjectAdded) events.get(0);

        Assertions.assertEquals(deliveryObjectId.value(), event.getDeliveryObjectId().value());
        Assertions.assertEquals(category.value(), event.getCategory().value());
        Assertions.assertEquals(amount.value(), event.getAmount().value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new CustomerRequestCreated(CustomerRequestId.of("xxxx"), new MyDate(Date.from(Instant.now())))
        );
    }
}