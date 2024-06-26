package dto;

// Data Transfer Object
public class StudentDto {
    private int number;
    private String name;
    private double height;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", height=" + height +
                '}';
    }

}
