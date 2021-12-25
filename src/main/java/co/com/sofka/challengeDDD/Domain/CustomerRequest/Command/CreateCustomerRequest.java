package co.com.sofka.challengeDDD.Domain.CustomerRequest.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.Command;

public class CreateCustomerRequest extends Command {

    private final CustomerRequestId customerRequestId;
    private final MyDate myDate;

    public CreateCustomerRequest(CustomerRequestId customerRequestId, MyDate myDate){
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
