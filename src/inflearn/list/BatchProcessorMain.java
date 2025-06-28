package inflearn.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BatchProcessorMain {

    /*
     * 추상적인 MyList에 의존하는 BatchProcessor
     * BatchProcessor 생성 시점에 어떤 List를 사용할지 선택 가능해진다.
     * 이렇게 하면 `MyList` 를 사용하는 클라이언트 코드인 `BatchProcessor` 를 전혀 변경하지 않고
     * 런타임에 지정 가능하다.
     */
    public static void main(String[] args) {
        BatchProcessor pc1 = new BatchProcessor(new MyArrayList<>());
        BatchProcessor pc2 = new BatchProcessor(new MyLinkedList<>());

        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        System.out.println(list.get(2));
        System.out.println(list.indexOf(1));




    }
}
