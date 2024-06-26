public class Account {
    private String accountNumber;
    private String ownerName;
    private int balance;

    // 생성자
    public Account(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 계좌 정보 출력 메소드
    public void printAccountInfo(){
        System.out.printf("계좌번호 : %s, 소유자 : %s, 잔액 : %d\n ",accountNumber,ownerName,balance);
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
