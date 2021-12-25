package co.com.sofka.challengeDDD.Delivery.Entity;

import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.challengeDDD.Delivery.IDS.BillId;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Bill extends Entity<BillId> {

    private Amount amount;
    public MyDate billDate;

    public Bill(BillId billId, Amount amount, MyDate billDate){
        super(billId);
        this.amount = amount;
        this.billDate = billDate;
    }

    public void updateValue(Amount value){
        this.amount = Objects.requireNonNull(value);
    }

    public void updateBillDate(MyDate billDate){
        this.billDate = Objects.requireNonNull(billDate);
    }
}
