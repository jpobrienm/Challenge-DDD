package co.com.sofka.challengeDDD.Domain.CustomerRequest;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.DeliveryObject;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Reciever;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.DeliveryObjectAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.RecieverAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.SenderAdded;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.DeliveryObjectId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.RecieverId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.SenderId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Value.Category;
import co.com.sofka.challengeDDD.Generics.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class CustomerRequest extends AggregateEvent<CustomerRequestId> {

    protected Reciever reciever;
    protected Sender sender;
    protected DeliveryObject deliveryObject;
    protected MyDate myDate;

    public CustomerRequest(CustomerRequestId customerRequestId, MyDate myDate){
        super(customerRequestId);
        this.myDate = myDate;
        appendChange(new CustomerRequestCreated(customerRequestId, myDate)).apply();
    }

    private CustomerRequest(CustomerRequestId customerRequestId){
        super(customerRequestId);
        subscribe(new CustomerRequestChange(this));
    }

    public static CustomerRequest from(CustomerRequestId customerRequestId, List<DomainEvent> events){
        var customerRequest = new CustomerRequest(customerRequestId);
        events.forEach(customerRequest::applyEvent);
        return customerRequest;
    }

    public void addReciever(Name name, Identification identification, Address address){
        var recieverId = new RecieverId();
        Objects.requireNonNull(name);
        Objects.requireNonNull(identification);
        Objects.requireNonNull(address);
        appendChange(new RecieverAdded(recieverId, name, identification, address)).apply();
    }

    public void addSender(Name name, Identification identification){
        var senderId = new SenderId();
        Objects.requireNonNull(name);
        Objects.requireNonNull(identification);
        appendChange(new SenderAdded(senderId, name, identification)).apply();
    }

    public void addDeliveryObject(Category category, Amount amount){
        var deliveryObjectId = new DeliveryObjectId();
        Objects.requireNonNull(category);
        Objects.requireNonNull(amount);
        appendChange(new DeliveryObjectAdded(deliveryObjectId, category, amount)).apply();
    }

}