import java.util.Scanner;


public class BankApplication {
    private static Account[] accounts = new Account[100];
    private static int count =0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while(running){
            printMenu();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    createAccount(sc);
                    break;
                case 2:
                    printAllAccounts();
                    break;
                case 3:
                    searchAccounts(sc);
                    break;
                case 4:
                    deleteAccount(sc);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");

            }

        }
        sc.close();

    }

    private static void createAccount(Scanner sc){
        System.out.println("새 계좌 정보를 입력하세요. (형식: 계좌번호 소유자 잔액)");
        String accountNumber = sc.next();
        String ownerName = sc.next();
        int balance = sc.nextInt();

        accounts[count++] = new Account(accountNumber, ownerName, balance);
        System.out.println("계좌가 생성되었습니다.");
    }

    private static void printAllAccounts(){
        System.out.println("\n저장된 모든 계좌 정보를 출력합니다.");
        for (int i = 0; i < count; i++) {
            accounts[i].printAccountInfo();
        }
    }

    private static void searchAccounts(Scanner sc){
        System.out.println("검색할 계좌번호를 입력하세요:");
        String accountNumber = sc.next();
        boolean found = false;
        for(int i = 0; i < count; i++){
            if(accounts[i].getAccountNumber().equals(accountNumber)){
                accounts[i].printAccountInfo();
                found = true;
            }
        }
        if(!found){
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    private static void deleteAccount(Scanner sc){
        System.out.println("삭제할 계좌번호를 입력하세요:");
        String accountNumber = sc.next();
        for(int i=0;i<count;i++){
            if(accounts[i].getAccountNumber().equals(accountNumber)){
                System.arraycopy(accounts, i + 1, accounts, i, count - i - 1); // 앞으로 배열 당기기
                count--;
                System.out.println("계좌가 삭제되었습니다.");
                return;
            }
        }
        System.out.println("계좌를 찾을 수 없습니다.");
    }


    public static void printMenu() {
        System.out.println("\n은행 계좌 관리 애플리케이션");
        System.out.println("1. 계좌 생성");
        System.out.println("2. 계좌 목록 보기");
        System.out.println("3. 계좌 정보 검색");
        System.out.println("4. 계좌 삭제");
        System.out.println("5. 프로그램 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
}
