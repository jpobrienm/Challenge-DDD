package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddBill;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddPackage;
import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;

import java.beans.FeatureDescriptor;

public class AddPackageUseCase extends UseCase<RequestCommand<AddPackage>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPackage> requestCommand){
        var command = requestCommand.getCommand();
        var delivery = Delivery.from(command.getDeliveryId(), retrieveEvents(command.getPackageId().value()));
        delivery.addPackage(command.getPackageId(),
                command.getDimensions(),
                command.getWeight());
        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
