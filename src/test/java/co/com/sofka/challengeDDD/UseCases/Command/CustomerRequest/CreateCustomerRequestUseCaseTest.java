package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.CreateCustomerRequest;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CreateCustomerRequestUseCaseTest {

    @Test
    void createCustomerRequestUseCaseTest(){
        // arrange
        CustomerRequestId customerRequestId = CustomerRequestId.of("xxxx");
        MyDate myDate = new MyDate(Date.from(Instant.now()));

        var command = new CreateCustomerRequest(customerRequestId, myDate);
        var useCase = new CreateCustomerRequestUseCase();

        // act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();

        // assert
        var event = (CustomerRequestCreated) events.getDomainEvents().get(0);
        Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals(myDate.value(), event.getMyDate().value());
    }

}