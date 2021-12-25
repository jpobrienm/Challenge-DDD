package co.com.sofka.challengeDDD.Domain.CustomerRequest.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Command;

public class AddSender extends Command {

    private final SenderId senderId;
    private final Name name;
    private final Identification identification;

    public AddSender(SenderId senderId, Name name, Identification identification){
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
