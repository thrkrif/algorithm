package inflearn.list;

public class MyLinkedList<E> implements MyList<E>{
    private Node<E> first;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    // 노드 맨 뒤에 추가
    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null){
            first = newNode;
        } else {
        Node<E> lastNode = getLastNode();
        lastNode.next = newNode;
        }
        size++;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;
        while (x != null){
            x = x.next;
        }
        return x;
    }


    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0){ // 맨 앞 삽입 시
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
    }

    // index에 해당하는 노드의 요소(item) 추출
    @Override
    public E get(int index) {
        Node<E> node = getNode(index); // index에 해당하는 노드 받아옴
        return node.item;
    }

    // index에 해당하는 노드 추출
    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++){
            x = x.next;
        }
        return x;
    }

    // 노드의 index 추출
    @Override
    public int indexOf(E o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next){
            if (x.item.equals(o)){
                return index;
            }
            index++;
        }
        return -1;
    }

    // 해당 인덱스의 요소 변경
    @Override
    public E set(int index, E element) {
        Node<E> modified = getNode(index); // 해당 인덱스의 노드 가져오기
        E oldValue = modified.item; // 이전 값
        modified.item = element; // 값 수정
        return oldValue; // 이전 값 반환
    }

    // 해당 인덱스의 요소를 제거함.
    // 마지막 요소를 제거하는 경우 prev.next = null 처리만 하면 됨.
    // 첫번째 요소를 제거하는 경우 -> 아무 연결 해 줄 필요 없지 않나? 그냥 본인만 null 처리 해주면 됨.
    // 중간 요소를 제거 하는 경우
    @Override
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item; // 반환할 삭제 값
        if (index == 0){
            first = removeNode.next; // 현재 removeNode가 index == 0 이며 first 노드 이니까 removeNode.next = first로 변경해줌
        }else {
            Node<E> prev = getNode(index - 1);
            prev.next = removeNode.next;
        }
        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removedItem;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }


    private static class Node<E>{
        E item;
        Node<E> next;

        public Node(E item){
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> temp = this;
            sb.append("[");
            while (temp != null){
                sb.append(temp.item);
                if (temp.next != null){
                    sb.append("->");
                }
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
