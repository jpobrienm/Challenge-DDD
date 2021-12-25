package co.com.sofka.challengeDDD.Domain.CustomerRequest.Entity;

import co.com.sofka.challengeDDD.Domain.CustomerRequest.Value.Category;
import co.com.sofka.challengeDDD.Domain.CustomerRequest.IDS.DeliveryObjectId;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class DeliveryObject extends Entity<DeliveryObjectId> {

    private Category category;
    private Amount amount;

    public DeliveryObject(DeliveryObjectId objectId, Category category, Amount amount){
        super(objectId);
        this.category = category;
        this.amount = amount;
    }

    public void uodateCategory(Category category){
        this.category = Objects.requireNonNull(category);
    }

    public void updateAmount(Amount amount){
        this.amount = Objects.requireNonNull(amount);
    }
}
