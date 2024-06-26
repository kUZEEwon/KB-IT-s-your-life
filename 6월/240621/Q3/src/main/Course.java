package main;

public class Course {
    String courseName;
    int maxStudents;
    int currentStudents;
    int subjectCount;
    int maxSubjects;
    Student[] students;
    Subject[] subjects;



    public void addStudent(Student student) {
        if (currentStudents < maxStudents) {
            this.students[currentStudents++] = student;
        }
    }

    public void addSubject(Subject subject) {
        if (subjectCount < maxStudents) {
            this.subjects[subjectCount++] = subject;
        }
    }

    public void printCourseInfo() {
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Max Students: " + this.maxStudents);
        System.out.println("Current Students: " + this.currentStudents);

        for (Student student : this.students) {
            if (student != null) {
                System.out.println("Student: " + student.name + " - " + student.department);
            }
        }

        for (Subject subject : this.subjects) {
            if (subject != null) {
                System.out.println("Subject: " + subject.name + " - Score: " + subject.score);
            }
        }
    }
}
