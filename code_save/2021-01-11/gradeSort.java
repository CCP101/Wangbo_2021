import java.util.Arrays;
import java.util.Scanner;

public class gradeSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] studentGrade = {99,85,82,63,60};
        Arrays.sort(studentGrade);
        int index = studentGrade.length;
        int addNumber = input.nextInt();
        for (int i = 0; i < studentGrade.length; i++) {
            if (addNumber<studentGrade[i]){
                index = i;
                break;
            }
        }
        int[] newStudentGrade = new int[studentGrade.length+1];
        for (int i = 0; i < newStudentGrade.length; i++) {
            if (i<index){
                newStudentGrade[i]=studentGrade[i];
            }else if (i==index){
                newStudentGrade[i]=addNumber;
            }else{
                newStudentGrade[i]=studentGrade[i-1];
            }
        }
        System.out.println("新数组为"+Arrays.toString(newStudentGrade));
    }
}
