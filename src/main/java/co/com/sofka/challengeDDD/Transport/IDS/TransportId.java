package co.com.sofka.challengeDDD.Transport.IDS;

import co.com.sofka.domain.generic.Identity;

public class TransportId extends Identity {
    private TransportId(String value){super(value);}
    public TransportId(){}
    public static TransportId of(String value){return new TransportId(value);}
}
