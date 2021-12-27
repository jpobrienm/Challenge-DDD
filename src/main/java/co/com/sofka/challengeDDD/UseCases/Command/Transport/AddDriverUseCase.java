package co.com.sofka.challengeDDD.UseCases.Command.Transport;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddBill;
import co.com.sofka.challengeDDD.Domain.Transport.Command.AddDriver;
import co.com.sofka.challengeDDD.Domain.Transport.Transport;

public class AddDriverUseCase extends UseCase<RequestCommand<AddDriver>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddDriver> requestCommand){
        var command = requestCommand.getCommand();
        var transport = Transport.from(command.getTransportId(), retrieveEvents(command.getDriverId().value()));
        transport.addDriver(command.getDriverId(),
                command.getName(),
                command.getIdentification(),
                command.getWorktime());
        emit().onResponse(new ResponseEvents(transport.getUncommittedChanges()));
    }
}
