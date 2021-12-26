package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddDeliveryObject;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddReciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;

public class AddDeliveryObjectUseCase extends UseCase<RequestCommand<AddDeliveryObject>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddDeliveryObject> requestCommand){
        var command = requestCommand.getCommand();
        var customerRequest = CustomerRequest.from(command.getCustomerRequestId(), retrieveEvents(command.getDeliveryObjectId().value()));
        customerRequest.addDeliveryObject(command.getDeliveryObjectId(),
                command.getCategory(),
                command.getAmount());
        emit().onResponse(new ResponseEvents(customerRequest.getUncommittedChanges()));
    }
}
