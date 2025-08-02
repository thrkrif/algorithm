package priorityQueue;

public class Member implements Comparable<Member>{
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /*
     * compareTo는 두 객체가 같으면 0, this가 비교하는 값보다 작으면 음수
     * this가 비교하는 값보다 크면 양수를 반환하도록 구현해야한다. compare()도 마찬가지이다.
     */
    @Override
    public int compareTo(Member o) {
        return this.age-o.age;
    }
}
