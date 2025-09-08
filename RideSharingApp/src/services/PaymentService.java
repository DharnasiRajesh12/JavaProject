package services;

import models.Payment;

public class PaymentService {
	public void processPayment(Payment paymentMethod, double amount) {
        paymentMethod.pay(amount);
    }

}
