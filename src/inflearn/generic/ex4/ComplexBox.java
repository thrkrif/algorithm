package inflearn.generic.ex4;

import inflearn.generic.Animal;

public class ComplexBox <T extends Animal> {
    private T animal;

    public void set(T animal){
        this.animal = animal;
    }

    // 제네릭 메서드
    public <T> T printAndReturn(T t){
        System.out.println("animal.className: " + animal.getClass().getName());
        System.out.println("t.className: " + t.getClass().getName());
        // t.getName();
        // 제네릭 메서드가 제네릭 타입보다 우선순위를 가지고 제네릭 메서드에는 타입 매개변수 상한이 지정되지 않았기 때문에
        // Object로 판단되어 Object 메서드밖에 사용 불가능하다.
        // 호출 불가 메서드는 <T> 타입이다. <T extends Animal> 타입이 아니다.
        return t;
    }
}
