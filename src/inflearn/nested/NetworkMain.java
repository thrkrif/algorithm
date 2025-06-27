package inflearn.nested;

public class NetworkMain {
    public static void main(String[] args) {
        Network network = new Network();
        network.sendMessage("내부에 NetworkMessage 클래스가 작동되지만 보이지 않도록 함.");
    }
}
