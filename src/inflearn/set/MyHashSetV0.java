package inflearn.set;

import java.util.Arrays;

/*
 * 직접 구현하기, 중복,순서가 없으므로 구현이 쉽다.
 * add, remove, contains만 구현하면 된다.
 */
public class MyHashSetV0 {

    private int[] elementData = new int[10];
    private int size = 0;


    // contains 확인해야하므로 시간복잡도 O(n)
    public boolean add(int value){
        if (contains(value)) return false;
        elementData[size] = value;
        size++;
        return true;
    }

    // value가 이미 포함되어있는지 확인
    // 있으면 true, 없으면 false 반환
    // 시간 복잡도가 O(n)
    public boolean contains(int value){
        for (int data : elementData) {
            if (data == value){
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }


    // Arrays.copyOf(elementData, size)를 이용하여 실제 데이터만 나오도록 복사함.
    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(Arrays.copyOf(elementData,size)) +
                ", size=" + size +
                '}';
    }
}
