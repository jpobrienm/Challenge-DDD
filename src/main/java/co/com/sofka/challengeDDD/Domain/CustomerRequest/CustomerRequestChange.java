package co.com.sofka.challengeDDD.Domain.CustomerRequest;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.DeliveryObject;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Reciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.DeliveryObjectAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.RecieverAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.SenderAdded;
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

        apply((DeliveryObjectAdded event) ->{
            customerRequest.deliveryObject = new DeliveryObject(event.getDeliveryObjectId(),
                    event.getCategory(),
                    event.getAmount());
        });
    }
}
