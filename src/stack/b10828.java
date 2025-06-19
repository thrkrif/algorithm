package stack;


import java.util.ArrayList;
import java.util.Scanner;

/*
백준 10828
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

public class b10828 {

    private ArrayList<Integer> stack;

    /* 기본 생성자 굳이 만들지 않아도 자동 생성해주잖아?
     * 이거 주석 달면 NullPointerException 뜸. 기본 생성자를 자동으로 생성해 주는건 맞지만
     * stack에 참조 값을 주입해주지는 않음. 그러니까 stack = null; 로 되어있어서 오류가 발생함.
     */
    public b10828(){
        stack = new ArrayList<>();
    }

    private void push(int value){
        stack.add(value);
    }

    private int pop(){
        if(!stack.isEmpty()){
            return stack.remove(stack.size()-1);
        }
        return -1;
    }

    private int empty(){
        return stack.isEmpty() ? 1 : 0;
    }

    private int size(){
        return stack.size();
    }

    private int top(){
        if(stack.isEmpty()){
            return -1;
        }
        return stack.get(stack.size()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        b10828 stackImpl = new b10828(); // 인스턴스 변수, 메서드를 사용하려면 객체를 먼저 생성해야 한다.

        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            String command = sc.next();
            switch (command){
                case "push":
                    int value = sc.nextInt();
                    stackImpl.push(value);
                    break;
                case "pop":
                    System.out.println(stackImpl.pop());
                    break;
                case "empty":
                    System.out.println(stackImpl.empty());
                    break;
                case "size":
                    System.out.println(stackImpl.size());
                    break;
                case "top":
                    System.out.println(stackImpl.top());
                    break;
            }
        }
        sc.close();
    }
}

