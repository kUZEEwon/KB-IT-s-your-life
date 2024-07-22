package db_connect;

import java.util.Scanner;

public class DBConnectMain4 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("검색할 id: ");
        String id = scanner.nextLine();

        MemberDAO dao = new MemberDAO();
        MemberVO bag = dao.one(id);

        System.out.println("db검색 결과 " + bag);

        scanner.close();
    }

}
