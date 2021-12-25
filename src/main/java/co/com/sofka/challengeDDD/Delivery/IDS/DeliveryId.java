package co.com.sofka.challengeDDD.Delivery.IDS;

import co.com.sofka.domain.generic.Identity;

public class DeliveryId extends Identity {
    private DeliveryId(String value){super(value);}
    public DeliveryId(){}
    public static DeliveryId of(String value){return new DeliveryId(value);}
}
