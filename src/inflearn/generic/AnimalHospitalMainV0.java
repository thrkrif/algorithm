package inflearn.generic;

public class AnimalHospitalMainV0 {
    /*
     * 타입 안전성 O, 코드 재사용성 X -> 동물 종류마다 병원을 생성해야함.
     * 아마 뒤에 타입 매개변수 제한? extends 배우기 위함인듯
     */
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();
        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);
// 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();
// 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();
// 문제1: 개 병원에 고양이 전달
// dogHospital.set(cat); // 다른 타입 입력: 컴파일 오류
// 문제2: 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이2", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}
