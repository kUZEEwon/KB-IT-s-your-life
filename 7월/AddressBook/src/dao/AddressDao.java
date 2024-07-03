package dao;

import dto.HumanDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressDao {
    Scanner sc = new Scanner(System.in);

    // list
    private ArrayList<HumanDto> list;

    public AddressDao() {
        list = new ArrayList<HumanDto>();
    }

    // CRUD
    public void insert(){
        System.out.println("지인을 추가합니다.");

        System.out.println("이름 = ");
        String name = sc.nextLine();

        System.out.println("나이 = ");
        int age = sc.nextInt();

        System.out.print("전화번호 = ");
        String phone = sc.next();

        // BufferReader로 읽어오기 => 띄어쓰기 반영 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("주소 = ");
        String address = "";

        try {
            address = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("메모 = ");
        String memo = "";
        try {
            memo = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        list.add(new HumanDto(name, age, phone, address, memo));
    }

    public void delete(){
        System.out.println("삭제할 지인의 이름 = ");
        String name = sc.nextLine();

        int index = search(name);
        if(index == -1){
            System.out.println("지인의 정보를 찾을 수 없어요.");
            return;
        }

        HumanDto dto = list.get(index);
        list.remove(index);
        System.out.println(dto.getName() + "님의 정보를 삭제했습니다.");
    }

    public void select(){
        System.out.println("검색할 지인의 이름 = ");
        String name = sc.next();

        ArrayList<HumanDto> FindList = new ArrayList<>();

        // 동명이인이 있을 경우를 대비해서 새로운 리스트 추가
        for(HumanDto dto : list){
            if(name.equals(dto.getName())){
                FindList.add(dto);
            }
        }

        if(FindList.size() == 0){
            System.out.println("지인의 정보를 찾을 수 없어요.");
            return;
        }

        for(HumanDto dto : FindList){
            System.out.println(dto.toString());
        }
    }


    // 검색하는 함수
    public int search(String name){
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            HumanDto dto = list.get(i);
            if(dto.getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }
    public void update(){
        System.out.print("수정할 지인의 이름 = ");
        String name = sc.next();

        int index = search(name);
        if(index == -1){
            System.out.println("지인의 정보를 찾을 수 없습니다");
            return;
        }

        System.out.print("전화번호 = ");
        String phone = sc.next();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("주소 = ");
        String address = "";
        try {
            address = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HumanDto human = list.get(index);
        human.setPhone(phone);
        human.setAddress(address);

        System.out.println("정상적으로 수정되었습니다");
    }


    // ALL
    public void all(){
        for (HumanDto h : list){
            System.out.println(h.toString());
        }
    }


}
