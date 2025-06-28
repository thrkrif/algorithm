package inflearn.list.test.ex2;

public class Item {
    private String name; // 이름
    private int price; // 가격
    private int quantity; // 수량
    public Item(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public int getTotalPrice() {
        return price * quantity;
    }
}
