package co.com.sofka.challengeDDD.Domain.Delivery.Command;

import co.com.sofka.challengeDDD.Domain.Delivery.IDS.BillId;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.Command;

public class AddBill extends Command {
    private final BillId billId;
    private final Amount amount;
    private final MyDate myDate;

    public AddBill(BillId billId, Amount amount, MyDate myDate){
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
