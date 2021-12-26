package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.CreateCustomerRequest;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.CreateDelivery;
import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;

public class CreateDeliveryUseCase extends UseCase<RequestCommand<CreateDelivery>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateDelivery> requestCommand){
        var command = requestCommand.getCommand();
        var delivery = Delivery.from(command.getDeliveryId(), retrieveEvents(command.getDeliveryId().value()));
        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
