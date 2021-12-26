package co.com.sofka.challengeDDD.UseCases.Command.CustomerRequest;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddReciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddSender;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;

public class AddSenderUseCase extends UseCase<RequestCommand<AddSender>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddSender> requestCommand){
        var command = requestCommand.getCommand();
        var customerRequest = CustomerRequest.from(command.getCustomerRequestId(), retrieveEvents(command.getSenderId().value()));
        customerRequest.addSender(command.getSenderId(),
                command.getName(),
                command.getIdentification());
        emit().onResponse(new ResponseEvents(customerRequest.getUncommittedChanges()));
    }
}
