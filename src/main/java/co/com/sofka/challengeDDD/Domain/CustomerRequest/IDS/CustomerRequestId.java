package co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS;

import co.com.sofka.domain.generic.Identity;

public class CustomerRequestId extends Identity {
    private CustomerRequestId(String value){super(value);}
    public CustomerRequestId(){}
    public static CustomerRequestId of(String value){return new CustomerRequestId(value);}
}
