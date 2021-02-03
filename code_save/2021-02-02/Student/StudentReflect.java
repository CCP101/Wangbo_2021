package Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StudentReflect {
    public static void main(String[] args) {
        System.out.println("-----------------------");
        System.out.println("① 使用多种方法生成一个Student类的Class对象");
        Student stu = new Student();
        Class<?> class1 = stu.getClass();
        Class<?> class2 = Student.class;
        try {
            Class<?> aClass = Class.forName("Student.Student");
            System.out.println("-----------------------");
            System.out.println("② 通过有参(无参)构造方法动态创建Student类的对象");
            Constructor<?> con1 = aClass.getConstructor();
            Student stu1 = (Student) con1.newInstance();
            System.out.println(stu1.toString());
            Constructor<?> con2 = aClass.getConstructor(String.class,int.class);
            Student stu2 = (Student) con2.newInstance(new Object[]{"张三",40});
            System.out.println(stu2.toString());
            System.out.println("-----------------------");
            System.out.println("③ 使用反射修改和查询Student类的姓名属性");
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(stu2,"李四");
            System.out.println(stu2.toString());
            System.out.println("-----------------------");
            System.out.println("④ 使用反射动态执行Student类输出信息的方法");
            Method mod = aClass.getMethod("show");
            mod.invoke(stu2);
            System.out.println("-----------------------");
            System.out.println("⑤ 使用Class类获取Student类的结构信息并输出 ");

            Constructor<?>[] constructors=aClass.getDeclaredConstructors();
            for (Constructor<?> constructor2 : constructors) {
                System.out.println(constructor2);
            }

            //获取方法对象
            Method[] methods=aClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException
                | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
