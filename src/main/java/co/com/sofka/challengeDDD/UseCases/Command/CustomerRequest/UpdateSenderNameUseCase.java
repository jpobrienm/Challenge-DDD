package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.UpdateSenderName;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;

public class UpdateSenderNameUseCase extends UseCase<RequestCommand<UpdateSenderName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateSenderName> requestCommand){
        var command = requestCommand.getCommand();
        var customerRequest = CustomerRequest.from(command.getCustomerRequestId(), retrieveEvents(command.getSender().identity().value()));
        customerRequest.updateSenderName(command.getName());
        emit().onResponse(new ResponseEvents(customerRequest.getUncommittedChanges()));
    }
}
