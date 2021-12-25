package co.com.sofka.challengeDDD.CustomerRequest;

import co.com.sofka.challengeDDD.CustomerRequest.Entity.DeliveryObject;
import co.com.sofka.challengeDDD.CustomerRequest.Entity.Reciever;
import co.com.sofka.challengeDDD.CustomerRequest.Entity.Sender;
import co.com.sofka.challengeDDD.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

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

    public void addReciever(Reciever reciever){
        this.reciever = reciever;
    }

}
