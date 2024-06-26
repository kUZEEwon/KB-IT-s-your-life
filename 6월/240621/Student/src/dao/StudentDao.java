package dao;

import dto.StudentDto;

import java.util.Scanner;

// Data Access Object
public class StudentDao {

    Scanner sc = new Scanner(System.in);

    private StudentDto studentDto[] = new StudentDto[5];
    private int count = 0;

    public void create() {
        System.out.println("학생 정보 추가");
        System.out.print("학생 이름 = ");
        String name = sc.next();

        System.out.print("학생 신장 = ");
        double height = sc.nextDouble();

        StudentDto dto = new StudentDto();
        dto.setNumber(count+1);
        dto.setName(name);
        dto.setHeight(height);

        studentDto[count] = dto;
        count++;
    }

    public void delete() {
        System.out.println("학생 정보 삭제");

        System.out.print("삭제할 학생 이름 = ");
        String name = sc.next();

        int index = -1;
        for (int i = 0; i < studentDto.length; i++) {

            if (studentDto[i] != null) {
                if (studentDto[i].getName().equals(name)) {
                    index = i;
                    break;
                }
            }
        }
        if (index != -1) {
            studentDto[index] = null;
        }

    }

    public void read(){
        System.out.println("학생 정보 검색");

        System.out.print("조회할 학생 이름 = ");
        String name = sc.next();

        int index = -1;
        for (int i = 0; i < studentDto.length; i++) {

            if (studentDto[i] != null) {
                if (studentDto[i].getName().equals(name)) {
                    index = i;
                    break;
                }
            }
        }
        if (index != -1) {
            System.out.println(studentDto[index].toString());

        }


    }

    public void update() {
        
    }
}
