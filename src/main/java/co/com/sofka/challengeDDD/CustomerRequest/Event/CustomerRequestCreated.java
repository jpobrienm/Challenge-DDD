package co.com.sofka.challengeDDD.CustomerRequest.Event;


import co.com.sofka.challengeDDD.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.DomainEvent;

public class CustomerRequestCreated extends DomainEvent {

    private final CustomerRequestId customerRequestId;
    private final MyDate myDate;

    public CustomerRequestCreated(CustomerRequestId customerRequestId, MyDate myDate){
        super("co.com.sofka.challengeDDD.customerRequestCreated");
        this.customerRequestId = customerRequestId;
        this.myDate = myDate;
    }

    public CustomerRequestId getCustomerRequestId(){
        return customerRequestId;
    }
    public MyDate getMyDate(){
        return myDate;
    }
}
