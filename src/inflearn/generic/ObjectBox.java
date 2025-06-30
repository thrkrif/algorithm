package inflearn.generic;

public class ObjectBox {
    private Object object;

    public void set(Object object){
        this.object = object;
    }

    public Object get(){
        return object;
    }
}
