package inflearn.generic;

public class AnimalMain1 {
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("냐옹이", 50);

        Box<Animal> animalBox = new Box<>();
        animalBox.set(animal);
        Animal findAnimal = animalBox.get();
        System.out.println("findAnimal = " + findAnimal);
        animalBox.set(dog);
        System.out.println("dog = " + dog);


    }
}
