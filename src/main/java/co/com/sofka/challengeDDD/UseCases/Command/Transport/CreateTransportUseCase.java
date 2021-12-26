package co.com.sofka.challengeDDD.UseCases.Command.Transport;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.Transport.Command.CreateTransport;
import co.com.sofka.challengeDDD.Domain.Transport.Transport;

public class CreateTransportUseCase extends UseCase<RequestCommand<CreateTransport>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateTransport> requestCommand){
        var command = requestCommand.getCommand();
        var transport = Transport.from(command.getTransportId(), retrieveEvents(command.getTransportId().value()));
        emit().onResponse(new ResponseEvents(transport.getUncommittedChanges()));
    }
}
