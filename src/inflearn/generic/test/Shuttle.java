package inflearn.generic.test;

public class Shuttle <T extends BioUnit>{

    private T unit;

    public void in(T t) {
        this.unit = t;
    }

    public T out() {
        return unit;
    }

    public void showInfo(){
        System.out.println("이름 : " + unit.getName() + ", HP : " + unit.getHp());
    }
}
