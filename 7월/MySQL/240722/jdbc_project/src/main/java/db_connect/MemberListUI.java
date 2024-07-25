package db_connect;

import java.util.ArrayList;

public class MemberListUI {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();
        ArrayList<MemberVO> list = dao.list();
        for (MemberVO bag : list) { // 9
            System.out.println(bag.getId());
            System.out.println(bag.getPw());
            System.out.println(bag.getName());
            System.out.println(bag.getTel());
            System.out.println("-------------------");
        }


        System.out.println("===========================");
        for (int i=0; i<list.size(); i++) {
            MemberVO bag = list.get(i);
            System.out.println(bag.getId());
            System.out.println(bag.getPw());
            System.out.println(bag.getName());
            System.out.println(bag.getTel());
            System.out.println("-------------------");
        }
    }
}