package stack;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
 * 올바르게 '()' 닫힌 괄호가 완성되는지에 대한 문제
 * (가 나올땐 push, )가 나올 땐 pop을한다.
 * 만약 스택에 무언가 남아있다면 VPS가 아님
 * 또한 스택이 비었는데 pop을 하면 VPS가 아님
 */
public class b9012 {

    // push, pop, size, empty, top
    ArrayList<Character> stack = new ArrayList<>();

    public b9012(){
        stack = new ArrayList<>();
    }

    private void push(char value){
        stack.add(value);
    }

    private char pop(){
        return stack.remove(stack.size() - 1);
    }

    private int size(){
        return stack.size();
    }

    // boolean이 아마 false이면 0, 0이 아닌 모든 값은 true
    // * 자바에서는 그게 아님. false나 true로만 표현 된다.
    private boolean empty(){
        return stack.isEmpty();
    }

    // 입력 할 때마다 스택을 초기화해줘야함.
    private void clear(){
        stack.clear();
    }

    // VPS 검증 메서드
    private boolean isVPS(String input){
        clear(); // 스택 초기화

//        char[] chars = input.toCharArray(); 안쓰고 바로 iter에서 사용 가능
        for (char ch : input.toCharArray()) {
            if (ch == '('){
                push(ch);
            }
            else {
                if (empty()) return false;
                else pop();
            }
        }
        return empty();
    }

    public static void main(String[] args) throws IOException {
        b9012 stackImpl = new b9012();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringBuilder sb = new StringBuilder(); // 출력

        int num = Integer.parseInt(br.readLine()); // 횟수 입력

        for (int i = 0; i < num; i++){
            String input = br.readLine();

            if (stackImpl.isVPS(input)){
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");
        }

        System.out.println(sb.toString());
    }
}
