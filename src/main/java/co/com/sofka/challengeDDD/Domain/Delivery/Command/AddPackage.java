package co.com.sofka.challengeDDD.Domain.Delivery.Command;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.PackageId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Dimensions;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Weight;
import co.com.sofka.domain.generic.Command;

public class AddPackage extends Command {
    private final DeliveryId deliveryId;
    private final PackageId packageId;
    private final Dimensions dimensions;
    private final Weight weight;

    public AddPackage(DeliveryId deliveryId, PackageId packageId, Dimensions dimensions, Weight weight){
        this.deliveryId = deliveryId;
        this.packageId = packageId;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
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
