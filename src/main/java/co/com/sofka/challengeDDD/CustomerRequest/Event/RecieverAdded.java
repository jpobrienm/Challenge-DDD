package co.com.sofka.challengeDDD.CustomerRequest.Event;

import co.com.sofka.challengeDDD.CustomerRequest.IDS.RecieverId;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.DomainEvent;

public class RecieverAdded extends DomainEvent {

    private final RecieverId recieverId;
    private final Name name;
    private final Identification identification;
    private final Address address;

    public RecieverAdded(RecieverId recieverId, Name name, Identification identification, Address address){
        super("co.com.sofka.challengeDDD.recieverAdded");
        this.recieverId = recieverId;
        this.name = name;
        this.identification = identification;
        this.address = address;
    }

    public RecieverId getRecieverId(){
        return recieverId;
    }

    public Name getName(){
        return name;
    }

    public Identification getIdentification(){
        return identification;
    }

    public Address getAddress(){
        return address;
    }
}
