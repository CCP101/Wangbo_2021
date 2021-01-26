import java.util.HashMap;

public class QQ {
    public static void main(String[] args) {
        HashMap<String,String> qq = new HashMap<>();
        qq.put("b","Q妹");
        qq.put("c","Q仔");
        qq.put("d","Q妹");
        for (String s : qq.keySet()) {
            System.out.println(s+"\t\t"+qq.get(s));
        }
    }
}
