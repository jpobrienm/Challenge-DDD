package co.com.sofka.challengeDDD.Domain.CustomerRequest.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Command;

public class UpdateSenderName extends Command {

    private final Name name;
    private final CustomerRequestId customerRequestId;
    private final Sender sender;

    public UpdateSenderName(CustomerRequestId customerRequestId, Sender sender, Name name) {
        this.customerRequestId = customerRequestId;
        this.name = name;
        this.sender = sender;
        this.sender.updateName(name);
    }

    public CustomerRequestId getCustomerRequestId() {
        return customerRequestId;
    }

    public SenderId senderId(){
        return this.sender.identity();
    }

    public Sender getSender() {
        return sender;
    }

    public Name getName() {
        return name;
    }
}
