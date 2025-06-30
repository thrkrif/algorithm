package inflearn.set;

// 인터페이스를 이용하여 해시 말고도 다른 자료구조를 이용하여 Set 구현 가능해진다.
public interface MySet<E> {
    boolean add(E element);

    boolean contains(E value);

    boolean remove(E value);
}
