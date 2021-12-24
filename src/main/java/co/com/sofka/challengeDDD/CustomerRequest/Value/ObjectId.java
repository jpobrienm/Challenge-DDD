package co.com.sofka.challengeDDD.CustomerRequest.Value;

import co.com.sofka.domain.generic.Identity;

public class ObjectId extends Identity {
    private ObjectId(String value){super(value);}
    public ObjectId(){}
    public static ObjectId of(String value){return new ObjectId(value);}
}
