package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddPackage;
import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.PackageAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.PackageId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Dimensions;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Weight;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AddPackageUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    void addPackageUseCaseTest(){
        // arrange
        DeliveryId deliveryId = DeliveryId.of("xxxx");
        PackageId packageId = PackageId.of("zzzz");
        Dimensions dimensions = new Dimensions(10.0, 10.0, 10.0);
        Weight weight = new Weight(12.0);

        var command = new AddPackage(deliveryId, packageId, dimensions, weight);
        var useCase = new AddPackageUseCase();

        Mockito.when(repository.getEventsBy(packageId.value())).thenReturn(EventStored());
        useCase.addRepository(repository);

        // act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(packageId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        PackageAdded event = (PackageAdded) events.get(0);

        // assert
        Assertions.assertEquals(packageId.value(), event.getPackageId().value());
        Assertions.assertEquals(dimensions.value().height(), event.getDimensions().value().height());
        Assertions.assertEquals(dimensions.value().width(), event.getDimensions().value().width());
        Assertions.assertEquals(dimensions.value().length(), event.getDimensions().value().length());
        Assertions.assertEquals(weight.value(), event.getWeight().value());
    }

    private List<DomainEvent> EventStored() {
        return List.of(
                new DeliveryCreated(DeliveryId.of("xxxx"), CustomerRequestId.of("yyyy"))
        );
    }

}