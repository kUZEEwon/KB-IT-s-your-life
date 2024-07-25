package dto;
import java.sql.*;


// @lombok : 안쓰면 좋겠다,,, (강사님)
// Data Transfer Object, Value Object
public class UserDto {
    @Override
    public String toString() {
        return "UserDto >> " +
                "id ='" + id + '\'' +
                ", name ='" + name + '\'' +
                ", age ='" + age + '\'' +
                ", joindate =" + joindate ;
    }

    private String id;
    private String name;
    private String joindate;
    private int age;

    public UserDto(String id, String name, int age, String joindate) {
        this.id = id;
        this.name = name;
        this.joindate = joindate;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {
        this.joindate = joindate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
