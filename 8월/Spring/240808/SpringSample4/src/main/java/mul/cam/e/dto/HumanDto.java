package mul.cam.e.dto;

public class HumanDto {
    private String name;
    private String birth;
    private String email;

    public HumanDto() {
    }

    public HumanDto(String name, String email, String birth ) {
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    @Override
    public String toString() {
        return "HumanDto{" +
                "name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
