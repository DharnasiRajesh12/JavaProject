package models;

public class CashPayment implements Payment {
	@Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " in Cash");
    }

}
