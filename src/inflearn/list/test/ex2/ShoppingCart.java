package inflearn.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> list = new ArrayList<>();

    public void addItem(Item item) {
        list.add(item);
    }

    public void displayItems() {
        System.out.println("상품 장바구니 출력");
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            System.out.println("상품명: " + list.get(i).getName() + ", 합계: " + list.get(i).getTotalPrice());
            total += list.get(i).getTotalPrice();
        }
        System.out.println("전체 가격 합: " + total);
    }
}
