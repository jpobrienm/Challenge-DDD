package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.CreateDelivery;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateDeliveryUseCaseTest {

    @Test
    void createDeliveryUseCaseTest(){
        // arrange
        DeliveryId deliveryId = DeliveryId.of("xxxx");
        CustomerRequestId customerRequestId = CustomerRequestId.of("yyyy");

        var command = new CreateDelivery(deliveryId, customerRequestId);
        var useCase = new CreateDeliveryUseCase();

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        // assert
        var event = (DeliveryCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("yyyy", event.getCustomerRequestId().value());
    }

}