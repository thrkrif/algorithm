package inflearn.generic;

public class BoxMain3 {

    public static void main(String[] args) {
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.set(10);
        System.out.println("integerBox = " + integerBox.get());


    }
}
