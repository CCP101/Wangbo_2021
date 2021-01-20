package student;

import java.util.Scanner;

public class test {
    public static void main(String[] args) throws MyException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Student student = new Student();
        student.speak(n);
    }
}
