package co.com.sofka.challengeDDD.CustomerRequest.Command;

import co.com.sofka.challengeDDD.CustomerRequest.IDS.CustomerRequestId;
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
