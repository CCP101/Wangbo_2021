package SetObj;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class SetObj {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("SetObj.Demo");
        Constructor<?> con = clazz.getConstructor();
        Demo d = (Demo) con.newInstance();
        setProperty(d,"str","XXX");
        System.out.println(d.toString());
    }

    public static void setProperty(Object obj,String propertyName,Object value) throws Exception{
        Class<?> cls = obj.getClass();
        Field field = cls.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}