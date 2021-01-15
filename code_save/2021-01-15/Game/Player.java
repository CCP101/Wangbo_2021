package Game;

import java.util.Scanner;

public class Player {
    private int levelNo = 0;
    private int currScore = 0;
    private long startTime;
    private int elapsedTime;

    /**玩游戏
     *
     */
    public void play(){
        Scanner input = new Scanner(System.in);
        Game game = new Game();
        for(;levelNo<=5;levelNo++){
            int length = LevelParam.levels[levelNo].getStrLength();
            boolean signFlag = LevelParam.levels[levelNo].isSignExist();
            int loopTime = LevelParam.levels[levelNo].getStrTimes();
            LevelParam.levels[levelNo].showLevelInformation();
            startTime = System.currentTimeMillis();
            //6个关卡
            for (int i = 0; i < loopTime; i++) {
                String randomStr = game.printStr(length,signFlag);
                System.out.println(randomStr);
                String inputStr = input.next();
                game.printResult(randomStr,inputStr);
                currScore+=LevelParam.levels[levelNo].getPerScore();
                long tempTime = System.currentTimeMillis();
                //计算当前间隔时间
                elapsedTime = (int)(tempTime - startTime)/1000;
                if (elapsedTime > LevelParam.levels[levelNo].getTimeLimit()){
                    System.out.println("你输入太慢了，已经超时，退出！");
                    System.exit(1);
                }
                System.out.println("输入正确，您的积分为"+currScore+",您的级别为"+(levelNo+1)+"，已用时间"+elapsedTime+"秒。");
            }
            long currentTime = System.currentTimeMillis();
            if ((currentTime - startTime) / 1000 > LevelParam.levels[levelNo].getTimeLimit()) {
                System.out.println("你输入太慢了，已经超时，退出！");
                System.exit(1);
            }else{
                System.out.println("恭喜你！闯关成功");
                boolean loopFlag = true;
                if (levelNo!=5)
                do {
                    System.out.print("请输入0继续闯关");
                    String tempStr = input.next();
                    if (tempStr.equals("0")) loopFlag = false;
                }while(loopFlag);
            }
            currScore = 0;
        }
        System.out.println("恭喜你！通关游戏");
    }
}
