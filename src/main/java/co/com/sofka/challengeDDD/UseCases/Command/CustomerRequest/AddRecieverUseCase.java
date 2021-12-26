package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddReciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;

import java.nio.charset.CoderMalfunctionError;

public class AddRecieverUseCase extends UseCase<RequestCommand<AddReciever>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddReciever> requestCommand){
        var command = requestCommand.getCommand();
        var customerRequest = CustomerRequest.from(command.getCustomerRequestId(), retrieveEvents(command.getRecieverId().value()));
        customerRequest.addReciever(command.getRecieverId(),
                command.getName(),
                command.getIdentification(),
                command.getAddress());
        emit().onResponse(new ResponseEvents(customerRequest.getUncommittedChanges()));
    }
}
