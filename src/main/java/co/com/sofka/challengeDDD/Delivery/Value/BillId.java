package co.com.sofka.challengeDDD.Delivery.Value;

import co.com.sofka.domain.generic.Identity;

public class BillId extends Identity {
    private BillId(String value){super(value);}
    public BillId(){}
    public static BillId of(String value){return new BillId(value);}
}
