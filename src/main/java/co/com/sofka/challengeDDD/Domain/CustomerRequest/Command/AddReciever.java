package co.com.sofka.challengeDDD.Domain.CustomerRequest.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.CustomerRequest;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.RecieverId;
import co.com.sofka.challengeDDD.Generics.Address;
import co.com.sofka.challengeDDD.Generics.Identification;
import co.com.sofka.challengeDDD.Generics.Name;
import co.com.sofka.domain.generic.Command;

public class AddReciever extends Command {
    private final CustomerRequestId customerRequestId;
    private final RecieverId recieverId;
    private final Name name;
    private final Identification identification;
    private final Address address;

    public AddReciever(CustomerRequestId customerRequestId, RecieverId recieverId, Name name, Identification identification, Address address){
        this.customerRequestId = customerRequestId;
        this.recieverId = recieverId;
        this.name = name;
        this.identification = identification;
        this.address = address;
    }

    public CustomerRequestId getCustomerRequestId() {
        return customerRequestId;
    }

    public RecieverId getRecieverId() {
        return recieverId;
    }

    public Name getName() {
        return name;
    }

    public Identification getIdentification() {
        return identification;
    }

    public Address getAddress() {
        return address;
    }
}
