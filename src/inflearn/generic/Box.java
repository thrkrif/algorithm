package inflearn.generic;

// 동물 상자
public class Box<T>{

    private T value;
    public void set(T value){
        this.value = value;
    }
    public T get(){
        return value;
    }
}
