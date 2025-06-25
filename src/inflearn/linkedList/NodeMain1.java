package inflearn.linkedList;

public class NodeMain1 {
    public static void main(String[] args) {
        // 노드 생성하고 연결하기.
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");

        node1.next = node2;
        node2.next = node3;

        // 모든 노드 탐색하기
//        Node x = node1;
//        while (x != null){
//            System.out.println(x.item);
//            x = x.next;
//        }
        
        // 위에처럼 연결을 해도 되지만, 이런식으로도 바로 연결 가능하다.
        Node node4 = new Node("D");
        node4.next = new Node("E");
        node4.next.next = new Node("F");

//        Node y = node4;
//        while (y != null){
//            System.out.println(y.item);
//            y = y.next;
//        }

        // Node 클래스에서 toString 오버라이딩
        System.out.println(node4);

        //노드 생성하고 연결하기: A -> B -> C
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        System.out.println(first);

        //모든 노드 탐색하기
        first.printAll(first);

        int index = 2;
        Node index2Node = first.getNode(first, index);
        System.out.println("index2Node = " + index2Node.item);

        //마지막 노드 조회하기
        Node lastNode = first.getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        //데이터 추가하기
        System.out.println("데이터 추가하기");
        first.add(first, "D");
        System.out.println(first);
        first.add(first, "E");
        System.out.println(first);
        first.add(first, "F");
        System.out.println(first);

    }
}
