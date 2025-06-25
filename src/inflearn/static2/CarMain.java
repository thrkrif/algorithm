package inflearn.static2;

public class CarMain {
    /*
     * 메서드 영역(static 영역, 상수 풀, 클래스 정보) (static, 정적, 클래스 변수)
     * 스택 영역(지역 변수)
     * 힙 영역(인스턴스 변수)
     */
    public static void main(String[] args) {
        Car car1 = new Car("K3");
        Car car2 = new Car("G80");
        Car car3 = new Car("Model Y");
        Car.showTotalCars(); //구매한 차량 수를 출력하는 static 메서드
    }

}
