package co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS;

import co.com.sofka.domain.generic.Identity;

public class DeliveryObjectId extends Identity {
    private DeliveryObjectId(String value){super(value);}
    public DeliveryObjectId(){}
    public static DeliveryObjectId of(String value){return new DeliveryObjectId(value);}
}
