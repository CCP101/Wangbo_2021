import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------��ӭ������Ϸ����-----------");
        System.out.println("��ȭ���� 1.���� 2.ʯͷ 3.�ܲ�");
        System.out.print("��ѡ��Է���ɫ(1.���� 2.��Ȩ 3.�ܲ�)��");
        int roleChoose = input.nextInt();
        int playerScore = 0;
        int computerScore = 0;
        int playTime = 0;
        String[] role = {"����","��Ȩ","�ܲ�"};
        String[] FLAG = {"��","ʯͷ","��"};
        System.out.print("�������������");
        String playerName = input.next();
        System.out.println(playerName + "  VS  " + role[roleChoose-1]+"��ս");
        System.out.print("Ҫ��ʼô��(y/n)");
        String startFlag = input.next();
        String loopFlag = "";
        if (startFlag.equals("y")){
            do{
                playTime++;
                System.out.print("���ȭ��1.�� 2.ʯͷ 3.��(������Ӧ����)");
                int choose = input.nextInt();
                int computerGuess = (int) (Math.random() * 3 + 1);
                System.out.println("���ȭ��"+FLAG[choose-1]);
                System.out.println(role[roleChoose-1]+"��ȭ��"+FLAG[computerGuess-1]);
                if (choose == computerGuess){
                    System.out.println("�����ƽ��");
                }else if (choose==1&&computerGuess==2||choose==2&&computerGuess==3||choose==3&&computerGuess==1){
                    System.out.println("������ź���������");
                    computerScore++;
                }else{
                    System.out.println("�������ϲ����Ӯ��");
                    playerScore++;
                }
                System.out.print("�Ƿ�ʼ��һ�֣�(y/n)");
                loopFlag = input.next();
            }while(!loopFlag.equals("n"));
        }
        System.out.println("-------------------------------");
        System.out.println(playerName + "  VS  " + role[roleChoose-1]+"��ս");
        System.out.println("��ս����:"+playTime);
        System.out.println("����\t\t�÷�");
        System.out.println(playerName+"\t\t"+playerScore);
        System.out.println(role[roleChoose-1]+"\t\t"+computerScore);
        String result = "";
        if (playerScore>computerScore){
            result="��ϲ��ϲ";
        }else if (playerScore==computerScore){
            result="ƽ��";
        }else{
            result="�ź�";
        }
        System.out.println("�����"+result);
        System.out.println("-------------------------------");
    }
}
