package co.com.sofka.challengeDDD.CustomerRequest;

import co.com.sofka.challengeDDD.CustomerRequest.Entity.Reciever;
import co.com.sofka.challengeDDD.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.CustomerRequest.Event.RecieverAdded;
import co.com.sofka.challengeDDD.CustomerRequest.Event.SenderAdded;
import co.com.sofka.domain.generic.EventChange;

public class CustomerRequestChange extends EventChange {
    public CustomerRequestChange(CustomerRequest customerRequest){

        apply((CustomerRequestCreated event) -> {
            customerRequest.myDate = event.getMyDate();
        });

        apply((RecieverAdded event)->{
            customerRequest.reciever = new Reciever(event.getRecieverId(),
                    event.getName(),
                    event.getIdentification(),
                    event.getAddress());
        });

        apply((SenderAdded event) ->{
            customerRequest.sender = new Sender(event.getSenderId(),
                    event.getName(),
                    event.getIdentification());
        });
    }
}
