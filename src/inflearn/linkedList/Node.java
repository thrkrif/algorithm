package inflearn.linkedList;

public class Node {
    Object item;
    Node next;

    public Node(Object item){
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node x = this;
        sb.append("[");
        while (x != null){
            if (x.next == null) {
                sb.append(x.item).append("]");
            } else {
                sb.append(x.item).append("->");
            }
            x = x.next;
        }
        return sb.toString();
    }

    // 모든 노드 탐색하기, 첫번째 노드를 넣어야 모든 노드 탐색 가능하다.
    public void printAll(Node first){
//        StringBuilder sb = new StringBuilder();
//        System.out.println("모든 노드 탐색하기");
//        while (first != null){
//            sb.append(first.item).append(" ");
//            first = first.next;
//        }
//        System.out.println(sb);
        System.out.println(first.toString());
    }

    // 특정 index의 노드 조회하기
    public Node getNode(Node first, int index){
        for (int i = 0; i < index; i++){
            first = first.next;
        }
        return first;
    }

    // 마지막 노드 조회하기
    public Node getLastNode(Node first){
        while (first.next != null){
            first = first.next;
        }
        return first;
    }

    public void add(Node node, Object item){
        Node lastNode = node.getLastNode(node);
        lastNode.next = new Node(item);

    }

}
