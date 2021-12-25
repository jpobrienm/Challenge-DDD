package co.com.sofka.challengeDDD.CustomerRequest.Entity;

import co.com.sofka.challengeDDD.CustomerRequest.IDS.RecieverId;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Reciever extends Entity<RecieverId> {

    private Name name;
    private Identification identification;
    private Address address;

    public Reciever(RecieverId recieverId, Name name, Identification identification, Address address){
        super(recieverId);
        this.name = name;
        this.identification = identification;
        this.address = address;
    }

    public void updateName(Name name){
        this.name = Objects.requireNonNull(name);
    }

    public void updateIdentification(Identification identification){
        this.identification = Objects.requireNonNull(identification);
    }

    public void updateAdress(Address address){
        this.address = Objects.requireNonNull(address);
    }
}
