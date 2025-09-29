package ch7.payment_system;

import static ch7.payment_system.ChargeType.BANK_TRANSFER_CHARGE;

public class BankTransferPayment extends Payment{
    public BankTransferPayment(long amount) {
        super(amount);
    }

    @Override
    public void processPayment() {
        double extraCharge = BANK_TRANSFER_CHARGE;
        System.out.printf("계좌 이체로 %.1f원 결제가 진행됩니다. (수수료: %.1f원)\n", this.amount, extraCharge);
    }
}
