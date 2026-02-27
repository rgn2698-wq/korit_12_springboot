package test2.test20;

class Student {
    int studentId;
    String name;

    // TODO: 기본 생성자를 작성하시오. (studentId: -1, name: "미정")
    public Student() {
        this.name = "미정";
        this.studentId = -1;
    }

    // TODO: 학번(studentId)만 받는 생성자를 작성하시오. (name: "미정")
    public Student(int studentId) {
        this.studentId = studentId;
        this.name = "미정";
    }

    // TODO: 학번(studentId)과 이름(name)을 모두 받는 생성자를 작성하시오.
    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public void printInfo() {
        System.out.println("학번: " + studentId + ", 이름: " + name);
    }
}

public class StudentFactory {
    public static void main(String[] args) {
        // TODO: 세 가지 생성자를 각각 사용하여 Student 객체를 생성하고 printInfo()를 호출하시오.
        Student stud1 = new Student();
        Student stud2 = new Student(2025001);
        Student stud3 = new Student("홍길동", 2025002);

        stud1.printInfo();
        stud2.printInfo();
        stud3.printInfo();
    }
}
