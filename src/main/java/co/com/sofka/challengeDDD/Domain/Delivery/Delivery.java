package co.com.sofka.challengeDDD.Domain.Delivery;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Entity.Bill;
import co.com.sofka.challengeDDD.Domain.Delivery.Entity.State;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.BillAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.DeliveryCreated;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.PackageAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.Event.StateAdded;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.BillId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.PackageId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.StateId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.DeliveryState;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Dimensions;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Weight;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Objects;

public class Delivery extends AggregateEvent<DeliveryId> {

    protected CustomerRequestId customerRequestId;
    protected Bill bill;
    protected State state;
    protected Package aPackage;

    public Delivery(DeliveryId deliveryId, CustomerRequestId customerRequestId){
        super(deliveryId);
        this.customerRequestId = customerRequestId;
        appendChange(new DeliveryCreated(deliveryId, customerRequestId)).apply();
    }

    private Delivery(DeliveryId deliveryId){
        super(deliveryId);
        subscribe(new DeliveryChange(this));
    }

    public static Delivery from(DeliveryId deliveryId, List<DomainEvent> events){
        var delivery = new Delivery(deliveryId);
        events.forEach(delivery::applyEvent);
        return delivery;
    }

    public void addBill(Amount amount, MyDate myDate){
        var billId = new BillId();
        Objects.requireNonNull(amount);
        Objects.requireNonNull(myDate);
        appendChange(new BillAdded(billId, amount, myDate)).apply();
    }

    public void addState(DeliveryState deliveryState, MyDate myDate){
        var stateId = new StateId();
        Objects.requireNonNull(deliveryState);
        Objects.requireNonNull(aPackage);
        appendChange(new StateAdded(stateId, deliveryState, myDate)).apply();
    }

    public void addPackage(Dimensions dimensions, Weight weight){
        var packageId = new PackageId();
        Objects.requireNonNull(dimensions);
        Objects.requireNonNull(weight);
        appendChange(new PackageAdded(packageId, dimensions, weight)).apply();
    }
}
