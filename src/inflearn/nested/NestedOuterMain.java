package inflearn.nested;

public class NestedOuterMain {

    public static void main(String[] args) {
        // 두 개의 인스턴스는 서로 아무런 연관이 없다.
        NestedOuter outer = new NestedOuter(); // 인스턴스 생성
        NestedOuter.Nested nested = new NestedOuter.Nested(); // 인스턴스 생성
        nested.print();

        System.out.println("nested class = " + nested.getClass());

        // 심지어 outer를 null로 만들어도
        outer = null;
        nested.print(); // 여전히 정상 작동한다. static은 인스턴스와 관계 없기 때문이다. -> 빈약한 설명
        /*
         * 정확한 이유는 메모리 저장 위치로 설명할 수 있다.
         * static 변수는 메서드 영역에 저장된다. 메서드 영역은 클래스 로딩 시 생성되며 프로그램이 종료할 때 까지 남아있다.
         * 인스턴스는 Heap 영역에 저장된다. 참조가 사라지면 GC에 의해 제거된다.
         * outer라는 인스턴스는 사라졌지만 그게 NestedOuter 라는 클래스가 사라진게 아니고 하나의 인스턴스만 사라졌다는거네.
         * NestedOuter 클래스 - 클래스 정보도 메서드 영역에 존재하니까 static 변수는 프로그램이 종료될 때까지 계속 남아있는거고
         */

        /*
         * 정적 중첩 클래스는 클래스 두 개를 따로 만드는것과 차이가 없다.
         * **딱 하나 차이가 있다면 외부 클래스의 private static 변수에 접근할 수 있다는 점이다.**
         */

    }
}
