package db_connect;

import java.util.Scanner;

public class DBConnectMain2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        String id = scanner.nextLine();
        MemberDAO dao = new MemberDAO();
      //  dao.delete(id);

      //  dao.insert("banana", "1111","jiwon","010-0000-2212");
        scanner.close();
    }
}
