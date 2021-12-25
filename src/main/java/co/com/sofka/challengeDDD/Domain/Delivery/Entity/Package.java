package co.com.sofka.challengeDDD.Domain.Delivery.Entity;

import co.com.sofka.challengeDDD.Domain.Delivery.Value.Dimensions;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.PackageId;
import co.com.sofka.challengeDDD.Domain.Delivery.Value.Weight;
import co.com.sofka.domain.generic.Entity;

public class Package extends Entity<PackageId> {

    private Dimensions dimensions;
    private Weight weight;

    public Package(PackageId packageId, Dimensions dimensions, Weight weight){
        super(packageId);
        this.dimensions = dimensions;
        this.weight = weight;
    }

    public void updateDimensions(Dimensions dimensions){
        this.dimensions = dimensions;
    }

    public void updateWeight(Weight weight){
        this.weight = weight;
    }
}
