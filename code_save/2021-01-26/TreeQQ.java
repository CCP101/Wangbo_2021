import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeQQ {
    public static void main(String[] args) {
        TreeMap<String,String> qq = new TreeMap<>();
        qq.put("a","Q妹");
        qq.put("b","Q妹");
        qq.put("c","Q妹");
        Set set = qq.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            Map.Entry me = (Map.Entry)it.next();
            System.out.print("Key is: "+me.getKey() + " & ");
            System.out.println("Value is: "+me.getValue());
        }
    }
}
