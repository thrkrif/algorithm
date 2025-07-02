package inflearn.generic;

public class DogHospital {
    private Dog animal;

    public void set(Dog animal){
        this.animal = animal;
    }

    public void checkup(){
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public Dog bigger(Dog target){
        return this.animal.getSize() > target.getSize() ? animal : target;
    }
}
