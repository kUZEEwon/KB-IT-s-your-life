public class Student implements Comparable<Student> {
    private String name;
    private int score;
    private String gender;

    public Student(String name,String gender, int score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public String getGender() {
        return gender;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(score, o.score);
    }
}
