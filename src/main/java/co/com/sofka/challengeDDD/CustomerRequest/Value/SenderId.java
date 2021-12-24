package co.com.sofka.challengeDDD.CustomerRequest.Value;

import co.com.sofka.domain.generic.Identity;

public class SenderId extends Identity {
    private SenderId(String value){super(value);}
    public SenderId(){}
    public static SenderId of(String value){return new SenderId(value);}
}
