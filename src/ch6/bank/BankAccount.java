package ch6.bank;

public class BankAccount {

    private long balance = 0;
    private String accountNumber;
    private String ownerName;

    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
    }

    public void deposit(long amount) {
        validateAmountUnderZero(amount);
        this.balance = this.balance + amount;
        System.out.printf("입금 후 잔액 : %d원\n", this.balance);
    }

    public void withdraw(long amount) {
        validateAmountUnderZero(amount);
        validateWithdrawAvailable(amount);
        this.balance = this.balance - amount;
        System.out.printf("출금 후 잔액 : %d원\n", this.balance);
    }

    public void getBalanceInfo() {
        System.out.printf("계좌번호: %s, 예금주: %s, 현재 잔액: %d원\n", accountNumber, ownerName, balance);
    }

    private void validateWithdrawAvailable(long amount) {
        if(amount > this.balance){
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }

    private void validateAmountUnderZero(long amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("유효하지 않은 금액입니다.");
        }
    }
}
