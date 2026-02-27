package test.test6;

class Member {
    private String name;
    private int age;

    // TODO: name에 대한 Getter와 Setter를 작성하시오.
    // Setter에는 이름이 null이 아니고 2글자 이상인지 검증하는 로직을 추가하시오.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 2) {
            System.out.println("유효하지 않은 이름입니다.");
            return;
        }
        this.name = name;
    }

    // TODO: age에 대한 Getter와 Setter를 작성하시오.
    // Setter에는 나이가 0에서 120 사이인지 검증하는 로직을 추가하시오.
    public int ageAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("유효하지않은 나이입니다.");
            return;
        }
        this.age = age;
    }

    public void printInfo() {
        System.out.println("이름: " + name + ", 나이: " + age);
    }
}

public class MemberManagement {
    public static void main(String[] args) {
        Member member = new Member();

        // TODO: 유효한 이름("이순신")과 유효하지 않은 나이(150)를 설정하고 정보를 출력하시오.
        // TODO: 유효하지 않은 이름("김")과 유효한 나이(30)를 설정하고 정보를 출력하시오.
        // TODO: 유효한 이름("강감찬")과 유효한 나이(45)를 설정하고 정보를 출력하시오.

        member.setName("이순신");
        member.setAge(150);
        member.printInfo();

        member.setName("김");
        member.setAge(30);
        member.printInfo();

        member.setName("강감찬");
        member.setAge(45);
        member.printInfo();
    }
}
