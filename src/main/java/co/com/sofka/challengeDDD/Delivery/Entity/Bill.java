package co.com.sofka.challengeDDD.Delivery.Entity;

import co.com.sofka.challengeDDD.Delivery.Value.BillDate;
import co.com.sofka.challengeDDD.Delivery.Value.BillId;
import co.com.sofka.domain.generic.Entity;
import com.sun.jdi.Value;

import java.util.Objects;

public class Bill extends Entity<BillId> {

    private Value value;
    public BillDate billDate;

    public Bill(BillId billId, Value value, BillDate billDate){
        super(billId);
        this.value = value;
        this.billDate = billDate;
    }

    public void updateValue(Value value){
        this.value = Objects.requireNonNull(value);
    }

    public void updateBillDate(BillDate billDate){
        this.billDate = Objects.requireNonNull(billDate);
    }
}
