package co.com.sofka.challengeDDD.Domain.Transport.Command;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Transport.IDS.TransportId;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.Command;

import java.util.Set;

public class CreateTransport extends Command {

    private TransportId transportId;
    private MyDate myDate;

    public CreateTransport(TransportId transportId, MyDate myDate){
        this.transportId = transportId;
        this.myDate = myDate;
    }

    public TransportId getTransportId() {
        return transportId;
    }

    public MyDate getMyDate() {
        return myDate;
    }
}
