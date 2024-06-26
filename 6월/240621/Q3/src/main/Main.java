package main;

public class Main {
    public static void main(String[] args) {
        Course course = new Course();
        course.courseName = "Java Programming";
        course.maxStudents = 30;
        course.students = new Student[course.maxStudents];
        course.subjects = new Subject[course.maxStudents];
        course.currentStudents = 0;
        course.subjectCount = 0;

        Student student1 = new Student();
        student1.id=2022001;
        student1.name="Kim";
        student1.grade = "1";
        student1.department = "computer science";
        course.addStudent(student1);


        Student student2 = new Student();
        student2.id=2022002;
        student2.name="Park";
        student2.grade = "2";
        student2.department = "computer science";
        course.addStudent(student2);


        Subject subject1 = new Subject();
        subject1.name = "Java";
        subject1.score = 95;
        course.addSubject(subject1);

        Subject subject2 = new Subject();
        subject2.name = "Python";
        subject2.score = 90;
        course.addSubject(subject2);

        course.printCourseInfo();
    }
}
