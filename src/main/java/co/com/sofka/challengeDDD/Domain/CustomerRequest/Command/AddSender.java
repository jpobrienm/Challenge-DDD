package co.com.sofka.challengeDDD.Domain.CustomerRequest.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Command;

public class AddSender extends Command {

    private final CustomerRequestId customerRequestId;
    private final SenderId senderId;
    private final Name name;
    private final Identification identification;

    public AddSender(CustomerRequestId customerRequestId, SenderId senderId, Name name, Identification identification){
        this.customerRequestId = customerRequestId;
        this.senderId = senderId;
        this.name = name;
        this.identification = identification;
    }

    public CustomerRequestId getCustomerRequestId() {
        return customerRequestId;
    }

    public SenderId getSenderId(){
        return senderId;
    }

    public Name getName(){
        return name;
    }

    public Identification getIdentification(){
        return identification;
    }
}
