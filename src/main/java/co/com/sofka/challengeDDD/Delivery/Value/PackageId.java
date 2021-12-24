package co.com.sofka.challengeDDD.Delivery.Value;

import co.com.sofka.domain.generic.Identity;

public class PackageId extends Identity {
    private PackageId(String value){super(value);}
    public PackageId(){}
    public static PackageId of(String value){return new PackageId(value);}
}
