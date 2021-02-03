package Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonReflect {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("Person.Person");
            Constructor<?> con1 = aClass.getConstructor();
            Person p1 = (Person) con1.newInstance();
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(p1,"李四");
            System.out.println(p1.toString());
            Method mod = aClass.getMethod("setAge", int.class);
            mod.invoke(p1,18);
            System.out.println(p1.toString());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
                | NoSuchFieldException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
