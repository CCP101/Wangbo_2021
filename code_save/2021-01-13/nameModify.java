import java.util.Arrays;
import java.util.Scanner;

public class nameModify {
    public static void main(String[] args) {
        String[] studentArray = new String[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("������ѧ��������");
            studentArray[i] = input.next();
        }
        System.out.println("����ѧ���б�");
        for (String x:studentArray) {
            System.out.print(x+"\t");
        }
//        System.out.print("�����޸ĵ�ѧ��������");
//        String oldName = input.next();
//        System.out.print("�����µ�ѧ��������");
//        String newName = input.next();
//        modifyStudent(oldName, newName, studentArray);
//        System.out.print("������ʾλ�ã�");
//        int begin = input.nextInt();
//        System.out.print("�������λ�ã�");
//        int end = input.nextInt();
//        System.out.print("����ѧ��������");
//        String searchName = input.next();
//        searchStudent(begin,end,searchName,studentArray);
        Arrays.sort(studentArray);
        System.out.println(Arrays.toString(studentArray));
    }

    private static void searchStudent(int begin, int end, String searchName, String[] studentArray) {
        boolean FLAG = false;
        for (int i = begin-1; i < (end-1); i++) {
            if (studentArray[i].equals(searchName)){
                System.out.println("���ҳɹ�");
                FLAG = true;
            }
        }
        if (!FLAG){
            System.out.println("û���ҵ���ѧ��");
        }
    }

    private static void modifyStudent(String oldName, String newName, String[] studentArray) {
        for (int i = 0; i < 5; i++) {
            if (studentArray[i].equals(oldName)){
                studentArray[i] = newName;
                System.out.println("�滻�ɹ�");
            }
        }
        System.out.println("����ѧ���б�");
        for (String x:studentArray) {
            System.out.print(x+"\t");
        }
    }
}
