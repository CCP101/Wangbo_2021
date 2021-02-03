package A;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class TestA {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入一个类的全类名:");
            String className = sc.nextLine();
            Class<?> clazz = Class.forName(className);
            Constructor<?> con2 = clazz.getConstructor();
            A a = (A) con2.newInstance();
            Method mod = clazz.getMethod("showString");
            mod.invoke(a);
        }catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
