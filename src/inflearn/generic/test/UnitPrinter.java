package inflearn.generic.test;

public class UnitPrinter {

    // 제네릭 메서드로 구현
    public static <T extends BioUnit> void printV1(Shuttle<T> t){
//        System.out.println("이름 = " + t.getName() + ", HP : " + t.getHp());
        /*
         * getName, getHp는 BioUnit꺼임. 지금은 Shuttle 안에 있는 메서드만 사용 가능하다.
         * 쓰고싶다면
         * BioUnit unit = t.out(); 을 이용하여 객체를 가져온 다음에
         * System.out.println("이름 = " + t.getName() + ", HP : " + t.getHp()); 를 작성하면 실행된다.
         */
        t.showInfo();
    }

    // 와일드 카드로 구현
    public static void printV2(Shuttle<? extends BioUnit> t){
        t.showInfo();
    }
}
