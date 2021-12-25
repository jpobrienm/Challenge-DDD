package co.com.sofka.challengeDDD.Domain.CustomerRequest.Event;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.DeliveryObjectId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Value.Category;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.domain.generic.DomainEvent;

public class DeliveryObjectAdded extends DomainEvent {

    private final DeliveryObjectId deliveryObjectId;
    private final Category category;
    private final Amount amount;

    public DeliveryObjectAdded(DeliveryObjectId deliveryObjectId, Category category, Amount amount){
        super("co.com.sofka.challengeDDD.deliveryObjectadded");
        this.deliveryObjectId = deliveryObjectId;
        this.category = category;
        this.amount = amount;
    }

    public DeliveryObjectId getDeliveryObjectId() {
        return deliveryObjectId;
    }

    public Category getCategory() {
        return category;
    }

    public Amount getAmount() {
        return amount;
    }
}
