package sec6.bank;

public class BankMain {
    public static void main(String[] args) {
        // 1. 홍길동의 계좌 생성
        System.out.println("새로운 계좌를 생성합니다.");
        BankAccount myAccount = new BankAccount("123-456-789", "홍길동");
        myAccount.getBalanceInfo();
        System.out.println();

        // 2. 50,000원 입금
        System.out.println("50,000원을 입금합니다.");
        myAccount.deposit(50000);
        System.out.println();

        // 3. 25,000원 출금
        System.out.println("25,000원을 출금합니다.");
        myAccount.withdraw(25000);
        myAccount.getBalanceInfo();
        System.out.println();

        // 4. 잔액보다 많은 금액 출금 시도
        System.out.println("30,000원을 출금 시도합니다.");
        myAccount.withdraw(30000);
        myAccount.getBalanceInfo();

    }
}
