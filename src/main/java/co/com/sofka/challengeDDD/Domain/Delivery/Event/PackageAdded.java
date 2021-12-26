package co.com.sofka.challengeDDD.Domain.Delivery.Event;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.PackageId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Dimensions;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Weight;
import co.com.sofka.domain.generic.DomainEvent;

public class PackageAdded extends DomainEvent {

    private final PackageId packageId;
    private final Dimensions dimensions;
    private final Weight weight;

    public PackageAdded(PackageId packageId, Dimensions dimensions, Weight weight){
        super("co.com.sofka.challengeDDD.packageAdded");
        this.packageId = packageId;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public PackageId getPackageId() {
        return packageId;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Weight getWeight() {
        return weight;
    }
}
