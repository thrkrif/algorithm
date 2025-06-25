package inflearn.static2;

public class DecoUtil1 {

    /*
     * 인스턴스 메서드임. static이 안붙었잖아.
     * 근데 지금 deco라는 기능은 멤버 변수도 없고 단순히 기능만 제공할 뿐이다.
     * 인스턴스를 사용하는 이유는 멤버 변수 등을 사용하는 목적이 큰데 이 메서드는 그렇지 않다.
     */
    public String deco(String str) {
        String result = "*" + str + "*";
        return result;
    }
}
