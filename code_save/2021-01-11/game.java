import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("----------欢迎进入游戏世界-----------");
        System.out.println("出拳规则 1.剪刀 2.石头 3.曹操");
        System.out.print("请选择对方角色(1.刘备 2.孙权 3.曹操)：");
        int roleChoose = input.nextInt();
        int playerScore = 0;
        int computerScore = 0;
        int playTime = 0;
        String[] role = {"刘备","孙权","曹操"};
        String[] FLAG = {"简刀","石头","布"};
        System.out.print("请输入你的姓名");
        String playerName = input.next();
        System.out.println(playerName + "  VS  " + role[roleChoose-1]+"对战");
        System.out.print("要开始么？(y/n)");
        String startFlag = input.next();
        String loopFlag = "";
        if (startFlag.equals("y")){
            do{
                playTime++;
                System.out.print("请出拳：1.简刀 2.石头 3.布(输入相应数字)");
                int choose = input.nextInt();
                int computerGuess = (int) (Math.random() * 3 + 1);
                System.out.println("你出拳："+FLAG[choose-1]);
                System.out.println(role[roleChoose-1]+"出拳："+FLAG[computerGuess-1]);
                if (choose == computerGuess){
                    System.out.println("结果：平局");
                }else if (choose==1&&computerGuess==2||choose==2&&computerGuess==3||choose==3&&computerGuess==1){
                    System.out.println("结果：遗憾，你输了");
                    computerScore++;
                }else{
                    System.out.println("结果：恭喜，你赢了");
                    playerScore++;
                }
                System.out.print("是否开始下一轮：(y/n)");
                loopFlag = input.next();
            }while(!loopFlag.equals("n"));
        }
        System.out.println("-------------------------------");
        System.out.println(playerName + "  VS  " + role[roleChoose-1]+"对战");
        System.out.println("对战次数:"+playTime);
        System.out.println("姓名\t\t得分");
        System.out.println(playerName+"\t\t"+playerScore);
        System.out.println(role[roleChoose-1]+"\t\t"+computerScore);
        String result = "";
        if (playerScore>computerScore){
            result="恭喜恭喜";
        }else if (playerScore==computerScore){
            result="平局";
        }else{
            result="遗憾";
        }
        System.out.println("结果："+result);
        System.out.println("-------------------------------");
    }
}
