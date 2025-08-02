package priorityQueue;

public class Student implements Comparable<Student>{
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 높은 점수가 우선 순위
    @Override
    public int compareTo(Student o) {
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}
