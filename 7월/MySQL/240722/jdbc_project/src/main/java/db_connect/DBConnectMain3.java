package db_connect;

import java.util.Scanner;

public class DBConnectMain3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("id: ");
        String id = scanner.nextLine();
        System.out.print("pw: ");
        String pw = scanner.nextLine();
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("tel: ");
        String tel = scanner.nextLine();
        MemberDAO dao = new MemberDAO();
        // 1. 가방을 만든다.
        MemberVO bag = new MemberVO();
        // 2. 가방에 데이터를 하나씩 넣자.
        bag.setId(id);
        bag.setPw(pw);
        bag.setName(name);
        bag.setTel(tel);
        // 3. 가방을 전달하자.
        int result = dao.insert(bag);
        if (result == 0){
            System. out.println( "insert failed");
        }else
        {
            System. out.println( "insert success");
        }
        scanner.close();
    }
}
