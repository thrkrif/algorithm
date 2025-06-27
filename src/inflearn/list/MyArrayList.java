package inflearn.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 5; // 초기 값 설정, final : 상수, 불변, static : 메서드 영역에 존재
    // 프로그램 시작 - 종료까지 남아있음.
    // final은 불변으로 변경 불가하다. 다른 클래스에서 사용하면서 set 같은걸로 수정 불가하다는거다. 그러나 static은 그게 가능
    // static은 모든 객체가 공유하는 필드라는 의미

    private Object[] elementData;
    private int size = 0; // 객체 생성마다 크기가 0이어야 하므로 static이 붙지 않는다.

    // 디폴트 생성자
    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY]; // Object 객체를 담을 수 있는 5칸짜리 리스트 생성
    }
    // 사용자가 크기 설정할 수도 있음.
    public MyArrayList(int initialCapacity){
        elementData = new Object[initialCapacity];
    }

    // 실제 배열에 들어가 있는 데이터의 개수
    @Override
    public int size() {
        return size;
//        return elementData.length; 이것도 맞지 않나? X 이건 배열의 총 크기를 말하는거임. 크기가 5인데 실제 데이터는 0,1,2 개 등이 들어갈 수 있음.
    }

    // 맨 뒤에 데이터를 추가하는 방식
    @Override
    public void add(E e) {
        if (size == elementData.length) {
            grow(); // 배열의 크기 == 실제 데이터가 들어간 크기 이면 1. 배열의 크기를 1 늘리고 2. 거기에 데이터를 추가해줘야한다.
        } // 2번 로직은 아래에 작성되어 있으니 grow()는 배열의 크기만 1 늘려주면 된다.
        elementData[size] = e;
        size++;
    }

    // 배열의 크기를 1 늘려준다., 배열의 크기를 어떻게 늘려줄 것인가?
    // ArrayList는 배열로 크기를 늘려주지 못하지 않나? 크기 늘리는건 LinkedList가 가능하지 않음?
    // 위의 말이 맞음. 배열을 복사해주는 방식을 사용해야함. 1씩 늘리는 경우 매번 복사해야하므로 메모리 낭비
    // 한 번에 기존 배열 크기 X 2 를 할 것.
    private void grow() {
//        int oldCapacity = elementData.length;
//        int newCapacity = oldCapacity * 2;
//        elementData = Arrays.copyOf(elementData, newCapacity);
        int newCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
        /*
         * Arrays.copyOf(배열, 용량) -> 용량만큼의 배열을 복사함.
         * 새로운 배열 (크기 10) elementData = ["A", "B", "C", "D", "E", null, null, null, null, null];
         * ↑ 기존 데이터들이 모두 복사됨 ↑  ← 새로 추가된 공간 (null로 초기화)
         */
    }

    // 시간 복잡도 O(1) : 배열의 index 탐색 + O(n) : 삽입 후 데이터들 1칸씩 이동 = O(n), 인데
    // 지금 직접 배열 만들고 있으므로 index 탐색도 우리가 구현해야함 -> 구현 완료
    // elementData.length == size 이면 grow 실행
    // index가 맨 마지막이라면 데이터만 추가하고 끝
    @Override
    public void add(int index, E e) {
        if(elementData.length == size){
            grow();
        }
        shiftRightFrom(index); // 처음 또는 중간에 데이터 삽입하는 경우 오른쪽으로 데이터들을 한칸씩 밀어야함.
        elementData[index] = e;
        size++;
    }

    private void shiftRightFrom(int index) {
        // 이미 오른쪽으로 이동할 만큼 elementData.length는 충분한 상태임.
        // add 매서드에서 용량이 부족하면 grow를 하므로 이 메서드에서는 쉬프트 연산만 하면 된다.
        for (int i = size; i > index; i--){
            elementData[i] = elementData[i - 1];
        }
    }

    // 인덱스에 해당하는 요소 조회
    @Override
    @SuppressWarnings("unchecked") // 컴파일러 경고 무시 어노테이션
    public E get(int index) {
        return (E) elementData[index]; // Object를 강제로 E로 변환했기 때문에 "unchecked cast" 경고 발생!
    }

    // 인덱스에 해당 하는 요소를 수정하고 이전 값을 반환함.
    @Override
    public E set(int index, E element) {
        E oldValue = get(index); // 이전 값을 oldValue에 저장
        elementData[index] = element; // 최신 값 적용
        return oldValue; // 이전 값 반환
    }

    // 1.맨 마지막에 있으면 그냥 삭제하면 됨.
    // 2. 1이 아니면 삭제하고 모두 왼쪽으로 한칸씩 데이터들을 당겨야함.
    @Override
    public E remove(int index) {
        E oldValue = get(index);
        shiftLeftFrom(index);
        size--;
        elementData[size] = null;
        return oldValue; // 삭제 값을 반환
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++){
            elementData[i] = elementData[i + 1];
        }
    }


    // 데이터가 있는 위치를 알려줌.
    @Override
    public int indexOf(E o) {
        for (int i = 0; i < elementData.length; i++){
            if (elementData[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        /*
         * Arrays.toString(Arrays.copyOf(elementData,size)) 라고 작성하는 이유?
         * Arrays.toString(elementData) 였으면 null 값들도 모두 출력될테니
         * 의미있는 데이터들만 출력하기 위해서 배열을 size만큼만 복사한다.
         */
        return Arrays.toString(Arrays.copyOf(elementData,size)) + " size=" +
                size + ", capacity=" + elementData.length;
    }
}
