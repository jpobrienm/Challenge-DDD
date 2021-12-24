package co.com.sofka.challengeDDD.CustomerRequest;

import co.com.sofka.challengeDDD.CustomerRequest.Value.CustomerRequestId;
import co.com.sofka.domain.generic.AggregateEvent;

public class CustomerRequest extends AggregateEvent<CustomerRequestId> {

    public CustomerRequest(CustomerRequestId clientId){
        super(clientId);
    }
}
