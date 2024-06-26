public class Company {
    public static void main(String[] args) {
        Employee work1 = new Employee("홍길동",25,"여");
        Employee work2 = new Employee("송중기",24, "남");
        Employee work3 = new Employee("변우석", 32, "남");

        // 1) 우리 회사의 직원 수는?
        System.out.println("우리 회사의 직원 수는?\t" + Employee.getTotalEmployee() + "명");


        // 2) 우리 회사의 직원 각각의 정보를 프린트
        System.out.println("직원 각각의 정보 : ");
        System.out.println(work1);
        System.out.println(work2);
        System.out.println(work3);

        // 3) 우리 회사의 직원의 평균 나이는?
        System.out.println("직원들의 평균 나이는?\t" + Employee.getAverageAge());


    }
}
