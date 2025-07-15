package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private Deque<String> stack = new ArrayDeque<>();

    public void visitPage(String url){
        stack.push(url);
        System.out.println("방문 : " + stack.peekFirst());
    }

    // 마지막 페이지인 경우도 고려해주면 더 좋을 거 같음.
    public String goBack(){
        if (stack.size() > 1){
            stack.pop(); // 현 페이지에서 벗어나야함.
            return stack.peek();
        }
        else if (stack.size() == 1){ // 마지막 페이지라면?
            System.out.println("더 이상 뒤로갈 수 없습니다. 마지막 페이지입니다. 현재 페이지를 반환합니다.");
            return stack.peek();
        } else return null; // 스택이 비어있는 경우라면
    }
}
