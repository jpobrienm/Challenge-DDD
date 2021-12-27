package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddPackage;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddState;
import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;

public class AddStateUseCase extends UseCase<RequestCommand<AddState>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddState> requestCommand){
        var command = requestCommand.getCommand();
        var delivery = Delivery.from(command.getDeliveryId(), retrieveEvents(command.getStateId().value()));
        delivery.addState(command.getStateId(),
                command.getDeliveryState(),
                command.getMyDate());
        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
