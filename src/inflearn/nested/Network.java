package inflearn.nested;

public class Network {
    /*
     * 중첩 클래스를 만들어보자.
     */
    public void sendMessage(String text) {
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }

    public static class NetworkMessage {
        private String content;
        private NetworkMessage(String content) { // private로 선언하여 외부에서 객체 만들 수 없게 만듦.
            this.content = content;
        }

        public void print() {
            System.out.println(content);
        }
    }
}
