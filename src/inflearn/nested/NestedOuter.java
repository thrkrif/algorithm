package inflearn.nested;

public class NestedOuter {
    /*
    중첩 클래스는 정적 중첩 클래스(static), non-static(내부, 지역, 익명 클래스) 로 구성되어있음.
    정적 중첩 클래스에 대해 공부 할 것임.
     */

    private static int outClassValue = 3; // static == 정적 == 클래스 변수
    private int outInstanceValue = 2; // 인스턴스 변수

    // 외부 클래스의 멤버에 접근 가능한가?
    // static 클래스는 객체를 생성하지 못한다. 인스턴스 변수는 객체를 생성해야 사용가능하므로 아마 인스턴스 변수는 접근 불가능 할 것이다. [O]
    static class Nested {
        private int nestedInstanceValue = 1; // 자신의 멤버엔 당연히 접근 가능함.

        public void print() {
            // 자신의 멤버에 접근
            System.out.println(nestedInstanceValue);

            // 바깥 클래스의 인스턴스 멤버에는 접근할 수 없다.
            //System.out.println(outInstanceValue);

            // 바깥 클래스의 클래스 멤버에는 접근할 수 있다. private 이더라도 접근 가능 - 왜냐하면 클래스 내부에 있잖아.
            System.out.println(NestedOuter.outClassValue);
        }

    }


}
