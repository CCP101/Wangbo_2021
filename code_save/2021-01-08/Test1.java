import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        System.out.println("����������ѡ���� 1.��¼ 2.�˳�");
        Scanner input = new Scanner(System.in);
        int choose = input.nextInt();
        switch (choose){
            case 1:
                System.out.println("�������û���������");
                String user = null;
                user = input.next();
                String password = null;
                password = input.next();
                if (user.equals("admin") && password.equals("admin")) {
                    System.out.println("��½�ɹ�");
                }else if(!password.equals("admin")){
                    System.out.println("�������");
                }else{
                    System.out.println("��½ʧ��");
                }
            case 2:
                System.out.println("�˳�ϵͳ");
            default:break;
        }
    }
}
