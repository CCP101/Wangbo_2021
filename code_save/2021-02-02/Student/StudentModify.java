package Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class StudentModify {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("Student.Student");
            Constructor<?> con2 = aClass.getConstructor(String.class,int.class);
            Student stu2 = (Student) con2.newInstance(new Object[]{"张三",40});
            System.out.println(stu2.toString());
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(stu2,"李四");
            System.out.println(stu2.toString());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
