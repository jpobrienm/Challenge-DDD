package co.com.sofka.challengeDDD.Domain.CustomerRequest.Event;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.DomainEvent;

public class SenderNameUpdated extends DomainEvent {

    private final Name name;
    private final Sender sender;

    public SenderNameUpdated(Sender sender, Name name) {
        super("co.com.sofka.challengeDDD.senderNameUpdated");
        this.name = name;
        this.sender = sender;
        this.sender.updateName(name);
    }

    public Sender getSender() {
        return sender;
    }

    public Name getName() {
        return name;
    }
}
