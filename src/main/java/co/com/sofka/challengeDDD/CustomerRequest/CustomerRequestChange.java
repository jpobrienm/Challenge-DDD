package co.com.sofka.challengeDDD.CustomerRequest;

import co.com.sofka.challengeDDD.CustomerRequest.Event.CustomerRequestCreated;
import co.com.sofka.domain.generic.EventChange;

public class CustomerRequestChange extends EventChange {
    public CustomerRequestChange(CustomerRequest customerRequest){

        apply((CustomerRequestCreated event) -> {
            customerRequest.myDate = event.getMyDate();
        });
    }
}
