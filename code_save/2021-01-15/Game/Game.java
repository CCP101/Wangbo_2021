package Game;

import java.util.Random;

public class Game {
    /** 输出字符串，返回字符串用于和玩家输入比较
     * @param length 字符串长度
     * @return 生成的字符串
     */
    public String printStr(int length,boolean flag) {
        StringBuilder buffer = new StringBuilder();
        Random random = new Random();
        String character = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberArray = "0123456789";
        String symbol = "!@#$%^&*()_+-*/=";
        int randomNumber;
        int randomResult;
        //首先随即决定类型
        for (int i = 0; i < length; i++) {
            //低难度不产生符号
            if (flag){
                randomNumber = random.nextInt(3);
            }else{
                randomNumber = random.nextInt(2);
            }
            switch (randomNumber){
                case 0:
                    //随机生成数字并插入
                    randomResult = random.nextInt(52);
                    buffer.append(character.charAt(randomResult));
                    break;
                case 1:
                    randomResult = random.nextInt(10);
                    buffer.append(numberArray.charAt(randomResult));
                    break;
                case 2:
                    randomResult = random.nextInt(16);
                    buffer.append(symbol.charAt(randomResult));
                    break;
            }
        }
        return buffer.toString();
    }

    /** 比较游戏输出out和玩家输入in，根据比较结果输出相应信息
     * @param out 系统生成字符串
     * @param in 输入字符串
     */
    public void printResult(String out, String in){
        if (!out.equals(in)){
            System.out.println("输入错误，退出");
            System.exit(1);
        }
    }
}
