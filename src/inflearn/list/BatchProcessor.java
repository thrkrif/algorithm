package inflearn.list;

public class BatchProcessor {

    /*
     * final 사용하는 이유 : 생성자에서 한 번만 할당함. -> 참조를 불변으로 만들기 위함
     * setter로 중간에 다른 리스트로 수정이 불가함.
     */
    private final MyList<Integer> list;

    // 외부에서 어떤 list일지가 결정된다. 이를 의존관계 주입(Dependency Injection) 이라고 하고
    // 지금 방식은 생성자를 이용한 의존관계 주입이다. -> 생성자 주입
    // 또한 지금 BatchProcessor 클래스 상에서는 MyList 인터페이스밖에 보이지 않는다.
    // 클래스에 보이는 의존관계를 컴파일 의존관계라고 한다.
    /* 런타임 의존관계는 실제로 프로그램이 실행될 때 보이는 의존관계이다.
     * 주로 생성된 인스턴스와 그것을 참조하는 의존 관계이다.
     * 쉽게 이야기해서 프로그램이 실행될 때 인스턴스 간에 의존관계로 보면 된다.
     * 런타임 의존관계는 프로그램 실행 중에 계속 변할 수 있다.
     */
    public BatchProcessor(MyList<Integer> list){
        this.list = list;
    }

    public void logic(int size) {
        for (int i = 0; i < size; i++) {
            list.add(0, i); //앞에 추가
        }
    }

}
