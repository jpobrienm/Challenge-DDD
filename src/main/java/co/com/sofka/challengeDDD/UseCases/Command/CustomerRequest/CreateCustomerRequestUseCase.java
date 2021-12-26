package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.CreateCustomerRequest;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;

public class CreateCustomerRequestUseCase extends UseCase<RequestCommand<CreateCustomerRequest>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateCustomerRequest> requestCommand){
        var command = requestCommand.getCommand();
        var customerRequest = CustomerRequest.from(command.getCustomerRequestId(), retrieveEvents(command.getCustomerRequestId().value()));
        emit().onResponse(new ResponseEvents(customerRequest.getUncommittedChanges()));
    }
}
