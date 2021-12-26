package co.com.sofka.challengeDDD.Domain.Delivery.Event;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.BillId;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.DomainEvent;

public class BillAdded extends DomainEvent {

    private final BillId billId;
    private final Amount amount;
    private final MyDate myDate;

    public BillAdded(BillId billId, Amount amount, MyDate myDate){
        super("co.com.sofka.challengeDDD.BillAdded");
        this.billId = billId;
        this.amount = amount;
        this.myDate = myDate;
    }

    public BillId getBillId() {
        return billId;
    }

    public Amount getAmount() {
        return amount;
    }

    public MyDate getMyDate() {
        return myDate;
    }
}
