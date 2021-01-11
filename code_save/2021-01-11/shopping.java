import java.util.Scanner;

public class shopping {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String shoppingCheck = "";
        int clothes_sum = 0;
        int checkFlag = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("第"+(i+1)+"家商铺，请选择购物或离开(y/n)");
            shoppingCheck = input.next();
            if (shoppingCheck.equals("y")){
                System.out.print("请输入购物数量");
                int clothes = input.nextInt();
                if (clothes<=3){
                    clothes_sum+=clothes;
                }else{
                    System.out.println("数字出错");
                    checkFlag = 1;
                    break;
                }
            }
        }
        if (checkFlag != 1){
            System.out.println("总共购买"+clothes_sum+"件衣服");
        }else{
            System.out.println("输入违反规范");
        }
    }
}
