package inflearn.generic.ex5;

import inflearn.generic.Animal;
import inflearn.generic.Cat;

public class WildcardEx {

    // static 제네릭 메서드 , 매개변수에 아예 통으로 Box<T> 클래스가 들어오는구나
    static <T> void printGenericV1(Box<T> box){
        System.out.println("T = " + box.get());
    }

    static void printWildcardV1(Box<?> box){
        System.out.println("? = " + box.get());
    }

    // 제네릭 메서드
    static <T extends Animal> void printGenericV2(Box<T> box){
        T t = box.get();
        System.out.println("이름 = " + t.getName());
    }

    // 와일드 카드 사용, 제네릭 메서드는 아님
    static void printWildcardV2(Box<? extends Animal> box) {
        Animal animal = box.get();
        // Cat animal = (Cat) box.get(); -> 다운 캐스팅 필요
        System.out.println("이름 = " + animal.getName());
    }

    // 제네릭 메서드
    static <T extends Animal> T printAndReturnGeneric(Box<T> box) {
        T t = box.get();
        System.out.println("이름 = " + t.getName());
        return t;
    }

    // 제네릭 메서드 아님, 와일드 카드 이용, 반환 값이 Animal 객체
    static Animal printAndReturnWildcard(Box<? extends Animal> box) {
        Animal animal = box.get();
        System.out.println("이름 = " + animal.getName());
        return animal;
    }
}
