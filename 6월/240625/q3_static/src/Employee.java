public class Employee {
    private String name;
    private int age;
    private String gender;

    private static int totalEmployee;
    private static int totalAge;

    public Employee(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        totalEmployee++;
        totalAge+=age;
    }

    public static int getTotalEmployee() {
        return totalEmployee;
    }

    public static double getAverageAge() {
        return (double) totalAge/totalEmployee;
    }

    @Override
    public String toString() {
        return "이름 : " +name + ", 나이 : " +age +", 성별 : "+gender;
    }
}
