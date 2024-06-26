package cls;

public class Human {
    /*
    * this : 0번째 매개변수로 생성된 클래스의 reference를 의미한다
    *       (생성된 객체의 주소)
    * */

    // 멤버  변수
    private String name;

    public Human method(){
        return this;
    }

    public void setName(String n) {
        // 멤버 변수와 매개 변수의 구분자
        // this.name = name;
        // this를 쓰고 싶지 않다면 매개변수 이름 바꾸기
        name = n;

        func();
        this.func();// 위와 동일한 결과가 나온다.
    }

    public String getName(){
        return name;
    }

    public void func(){
        String name;        // 지역 변수(local variable)


        this.name = "jiwon";
    }


}
