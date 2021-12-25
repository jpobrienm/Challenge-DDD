package co.com.sofka.challengeDDD.Domain.CustomerRequest.Command;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.DeliveryObjectId;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.Value.Category;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.domain.generic.Command;

public class AddDeliveryObject extends Command {

    private final DeliveryObjectId deliveryObjectId;
    private final Category category;
    private final Amount amount;

    public AddDeliveryObject(DeliveryObjectId deliveryObjectId, Category category, Amount amount){
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
