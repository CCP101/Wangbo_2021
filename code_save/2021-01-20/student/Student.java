package student;

public class Student {
    public void speak(int m) throws MyException{
        if (m>200){
            throw new MyException("参数的值大于200");
        }
    }
}
