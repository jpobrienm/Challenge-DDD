package co.com.sofka.challengeDDD.Domain.CustomerRequest.Event;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.DomainEvent;

public class SenderAdded extends DomainEvent {

    private final SenderId senderId;
    private final Name name;
    private final Identification identification;

    public SenderAdded(SenderId senderId, Name name, Identification identification){
        super("co.com.sofka.challengeDDD.senderAdded");
        this.senderId = senderId;
        this.name = name;
        this.identification = identification;
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
