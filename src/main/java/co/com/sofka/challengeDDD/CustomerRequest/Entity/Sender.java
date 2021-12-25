package co.com.sofka.challengeDDD.CustomerRequest.Entity;

import co.com.sofka.challengeDDD.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Sender extends Entity<SenderId>{

    private Name name;
    private Identification identification;

    public Sender(SenderId senderId, Name name, Identification identification){
        super(senderId);
        this.name = name;
        this.identification = identification;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updateIdentification(Identification identification){
        this.identification = Objects.requireNonNull(identification);
    }
}
