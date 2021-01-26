import java.util.TreeSet;

public class Tree {
    public static void main(String[] args) {
        TreeSet<Integer> num = new TreeSet<>();
        num.add(4);
        num.add(5);
        num.add(10);
        for (Integer integer : num) {
            System.out.println(integer);
        }
        num.add(6);
        for (Integer integer : num) {
            System.out.println(integer);
        }
    }
}
