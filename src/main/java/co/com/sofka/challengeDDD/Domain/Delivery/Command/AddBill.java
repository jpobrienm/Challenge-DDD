package co.com.sofka.challengeDDD.Domain.Delivery.Command;

import co.com.sofka.challengeDDD.Domain.Delivery.Delivery;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.BillId;
import co.com.sofka.challengeDDD.Domain.Delivery.IDS.DeliveryId;
import co.com.sofka.challengeDDD.Generics.Amount;
import co.com.sofka.challengeDDD.Generics.MyDate;
import co.com.sofka.domain.generic.Command;

public class AddBill extends Command {
    private final DeliveryId deliveryId;
    private final BillId billId;
    private final Amount amount;
    private final MyDate myDate;

    public AddBill(DeliveryId deliveryId, BillId billId, Amount amount, MyDate myDate){
        this.deliveryId = deliveryId;
        this.billId = billId;
        this.amount = amount;
        this.myDate = myDate;
    }

    public DeliveryId getDeliveryId() {
        return deliveryId;
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
