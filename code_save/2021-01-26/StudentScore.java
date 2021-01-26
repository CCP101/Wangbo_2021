import java.util.HashMap;

public class StudentScore {
    public static void main(String[] args) {
        HashMap<String,Integer> stu = new HashMap<>();
        stu.put("a",10);
        stu.put("b",20);
        stu.put("c",30);
        for (String i : stu.keySet()) {
            System.out.println("key: " + i + " value: " + stu.get(i));
        }
        stu.remove("b");
        for (String i : stu.keySet()) {
            System.out.println("key: " + i + " value: " + stu.get(i));
        }
    }
}
