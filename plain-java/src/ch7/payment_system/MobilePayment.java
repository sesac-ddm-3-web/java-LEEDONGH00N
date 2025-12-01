package ch7.payment_system;

import static ch7.payment_system.ChargeType.MOBILE_CHARGE_PERCENTAGE;

public class MobilePayment extends Payment{
    protected MobilePayment(long amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        double extraCharge = this.amount * MOBILE_CHARGE_PERCENTAGE;
        System.out.printf("모바일 페이로 %.1f원 결제가 진행됩니다. (수수료: %.1f원)\n", this.amount, extraCharge);
    }
}
