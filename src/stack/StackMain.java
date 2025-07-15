package stack;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {

        /*
         * push, pop, peek
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("0번째 인덱스 = " + stack.get(0));


        System.out.println(stack.peek()); // peek : 제일 마지막에 넣은 요소를 확인 (단순 조회)

        /*
         * 자바의 `Stack` 클래스는 내부에서 `Vector` 라는 자료 구조를 사용한다. 이 자료 구조는 자바 1.0에 개발되었는데,
         * 지금은 사용되지 않고 하위 호환을 위해 존재한다. 지금은 더 빠른 좋은 자료 구조가 많다. 따라서 `Vector` 를 사용하는
         * `Stack`도 사용하지 않는 것을 권장한다
         * Stack 사용하지 말고 Deque 사용해라
         */
    }
}
