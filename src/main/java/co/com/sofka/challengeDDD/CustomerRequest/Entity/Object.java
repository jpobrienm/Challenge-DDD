package co.com.sofka.challengeDDD.CustomerRequest.Entity;

import co.com.sofka.challengeDDD.CustomerRequest.Value.Category;
import co.com.sofka.challengeDDD.CustomerRequest.Value.ObjectId;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Object extends Entity<ObjectId> {

    private Category category;
    private Amount amount;

    public Object(ObjectId objectId, Category category, Amount amount){
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
