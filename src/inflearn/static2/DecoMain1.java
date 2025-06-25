package inflearn.static2;

import static inflearn.static2.DecoUtil2.deco;

public class DecoMain1 {
    public static void main(String[] args) {
        String s = "hello java";
        DecoUtil1 utils = new DecoUtil1(); // 인스턴스를 먼저 생성해야함
        String deco = utils.deco(s);

        System.out.println("before = " + s);
        System.out.println("after, instance version = " + deco);

        String deco2 = DecoUtil2.deco(s);
        System.out.println("after, static version = " + deco2);

        System.out.println("use import static = " + deco(deco2));
    }
}
