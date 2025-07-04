package inflearn.generic.ex5;

import inflearn.generic.Animal;
import inflearn.generic.Cat;
import inflearn.generic.Dog;

public class WildcardMain1 {
    public static void main(String[] args) {
        Box<Object> objBox = new Box<>();
        Box<Dog> dogBox = new Box<>();
        Box<Cat> catBox = new Box<>();
        dogBox.set(new Dog("멍멍이", 100)); // 사용할 타입을 생성 시점에 결정한다.
        // 최대한 미루면서 코드 재사용성, 타입 안전성을 늘린다.

        WildcardEx.printGenericV1(dogBox);
        WildcardEx.printWildcardV1(dogBox);
        WildcardEx.printGenericV2(dogBox);
        WildcardEx.printWildcardV2(dogBox);
        Dog dog = WildcardEx.printAndReturnGeneric(dogBox);
        Animal animal = WildcardEx.printAndReturnWildcard(dogBox);


    }
}
