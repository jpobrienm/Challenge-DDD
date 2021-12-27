package co.com.sofka.challengeDDD.UseCases.Command.Delivery;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Command.AddReciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;
import co.com.sofka.challengeDDD.Domain.Delivery.Command.AddBill;
import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;

public class AddBillUseCase extends UseCase<RequestCommand<AddBill>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddBill> requestCommand){
        var command = requestCommand.getCommand();
        var delivery = Delivery.from(command.getDeliveryId(), retrieveEvents(command.getBillId().value()));
        delivery.addBill(command.getBillId(),
                command.getAmount(),
                command.getMyDate());
        emit().onResponse(new ResponseEvents(delivery.getUncommittedChanges()));
    }
}
