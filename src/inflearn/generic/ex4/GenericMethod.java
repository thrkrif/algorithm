package inflearn.generic.ex4;

public class GenericMethod {
    public static Object objMethod(Object obj){
        System.out.println("object print = " + obj);
        return obj;
    }

    // 어떠한 타입이든 모두 들어올 수 있음.
    public static <T> T genericMethod(T t){
        System.out.println("genericMethod print = " + t);
        return t;
    }

    // Number로 타입 매개변수 제한
    public static <T extends Number> T numberMethod(T t){
        System.out.println("bound print = " + t);
        return t;
    }
}
