package main;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path = "C:\\Users\\koo\\Documents\\KB-IT-s-your-life\\6월\\240621\\Student_HW";


        String id;
        String pw;

        String title;
        String content;
        String date;

        System.out.println("ID를 입력하세요:");
        id = sc.nextLine();
        System.out.println("비밀번호를 입력하세요:");
        pw = sc.nextLine();

        if(id.equals("root") & pw.equals("1234")){
            System.out.println("일기 작성을 시작합니다.");
            System.out.println("날짜를 입력하세요 (예: 20240621):");
            date = sc.nextLine();
            System.out.println("제목을 입력하세요:");
            title = sc.nextLine();
            System.out.println("내용을 입력하세요:");
            content = sc.nextLine();

            try{
                // file 객체 생성
                File file = new File(path, date+ ".txt");

                // true 지정시 파일의 기존 내용에 이어서 작성
                FileWriter fw = new FileWriter(file, true) ;


                fw.write(date + "\t" + title + "\t" + content + "\n");
                fw.flush();

                fw.close();

                System.out.println("일기가 저장되었습니다: " + date+ ".txt");

            }catch (Exception e){
                e.printStackTrace();
            }




        }else{
            System.out.println("ID 또는 비밀번호가 잘 못되었습니다.");

        }

    }
}
