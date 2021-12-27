package co.com.sofka.challengeDDD.Domain.Delivery;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.CustomerRequestId;
import co.com.sofka.challengeDDD.Domain.Delivery.Entity.Bill;
import co.com.sofka.challengeDDD.Domain.Delivery.Entity.Package;
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

    public void addBill(BillId billId, Amount amount, MyDate myDate){
        Objects.requireNonNull(billId);
        Objects.requireNonNull(amount);
        Objects.requireNonNull(myDate);
        appendChange(new BillAdded(billId, amount, myDate)).apply();
    }

    public void addState(StateId stateId, DeliveryState deliveryState, MyDate myDate){
        Objects.requireNonNull(stateId);
        Objects.requireNonNull(deliveryState);
        Objects.requireNonNull(myDate);
        appendChange(new StateAdded(stateId, deliveryState, myDate)).apply();
    }

    public void addPackage(PackageId packageId, Dimensions dimensions, Weight weight){
        Objects.requireNonNull(packageId);
        Objects.requireNonNull(dimensions);
        Objects.requireNonNull(weight);
        appendChange(new PackageAdded(packageId, dimensions, weight)).apply();
    }

    public CustomerRequestId customerRequestId() {
        return customerRequestId;
    }

    public Bill bill() {
        return bill;
    }

    public State state() {
        return state;
    }

    public Package aPackage() {
        return aPackage;
    }
}
