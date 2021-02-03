import java.lang.reflect.Array;

public class ArrayModify {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("java.lang.String");
        Object arrObj = Array.newInstance(aClass,5);
        Array.set(arrObj,0,"张三");
        Object value = Array.get(arrObj,0);
        System.out.println(value);
    }
}
