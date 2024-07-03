package main;

import dao.AddressDao;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddressDao dao = new AddressDao();

        // menu
        while (true){
            System.out.println(" << 주소록 >> ");
            System.out.println("1. 지인추가");
            System.out.println("2. 지인삭제");
            System.out.println("3. 지인검색");
            System.out.println("4. 지인수정");
            System.out.println("5. 모두출력");
            System.out.println("6. 종료");

            System.out.print(">> ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    dao.insert();
                    break;
                case 2:
                    dao.delete();
                    break;
                case 3:
                    dao.select();
                    break;
                case 4:
                    dao.update();
                    break;
                case 5:
                    dao.all();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}
