package Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DogReflect {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("Dog.Dog");

            System.out.println("------------------------------");
            System.out.println("反射属性：");
            Field name = aClass.getDeclaredField("name");
            Field age = aClass.getDeclaredField("age");
            System.out.println(name);
            System.out.println(age);
            Field[] fields = aClass.getFields();
            for (Field f : fields) {
                System.out.println("Person中的所有public属性：" + f.getName());
            }

            System.out.println("------------------------------");
            System.out.println("反射方法：");
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            System.out.println("------------------------------");
            System.out.println("反射构造：");
            Constructor<?> con1 = aClass.getConstructor();
            Constructor<?> con2 = aClass.getConstructor(String.class,int.class,String.class,int.class,int.class);
            Dog dog2 = (Dog) con2.newInstance(new Object[]{"XXX",10,"YYY",50,50});
            System.out.println(dog2.toString());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
