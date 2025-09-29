package sec7.payment_system;

import static sec7.payment_system.ChargeType.*;

public class CreditCardPayment extends Payment{
    protected CreditCardPayment(long amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        double extraCharge = this.amount * CREDIT_CARD_CHARGE_PERCENTAGE;
        System.out.printf("신용카드로 %.1f원 결제가 진행됩니다. (수수료: %.1f원)\n", this.amount, extraCharge);
    }
}
