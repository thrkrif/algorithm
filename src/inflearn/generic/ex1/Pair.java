package inflearn.generic.ex1;

public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public void setFirst(T1 t){
        this.first = t;
    }

    public void  setSecond(T2 t){
        this.second = t;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
