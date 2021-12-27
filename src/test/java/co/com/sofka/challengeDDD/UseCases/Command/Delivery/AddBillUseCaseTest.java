package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddBill;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.BillAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.BillId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
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
class AddBillUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addBillUseCaseTest(){
        //arrange
        DeliveryId deliveryId = DeliveryId.of("xxxx");
        BillId billId = BillId.of("zzzz");
        Amount amount = new Amount(123);
        MyDate myDate = new MyDate(Date.from(Instant.now()));

        var command = new AddBill(deliveryId, billId, amount, myDate);
        var useCase = new AddBillUseCase();

        Mockito.when(repository.getEventsBy(billId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(billId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        BillAdded event = (BillAdded) events.get(0);

        // assert
        Assertions.assertEquals(billId.value(), event.getBillId().value());
        Assertions.assertEquals(amount.value(), event.getAmount().value());
        Assertions.assertEquals(myDate.value(), event.getMyDate().value());
        Mockito.verify(repository).getEventsBy(billId.value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new DeliveryCreated(DeliveryId.of("xxxx"), CustomerRequestId.of("yyyy"))
        );
    }

}