package co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS;

import co.com.sofka.domain.generic.Identity;

public class RecieverId extends Identity {
    private RecieverId(String value){super(value);}
    public RecieverId(){}
    public static RecieverId of(String value){return new RecieverId(value);}
}
