package shopping;

import java.util.Scanner;
import java.util.Vector;

public class Systemx {
    private static final Vector<VIP> userData = new Vector<>();

    public void creat(int number) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            System.out.print("请输入用户ID");
            String tempID = input.next();
            System.out.print("请输入用户积分");
            int tempPoint = input.nextInt();
            VIP tempUser = new VIP();
            tempUser.setId(tempID);
            tempUser.setPoint(tempPoint);
            userData.add(tempUser);
        }
    }

    public void show() {
        for (VIP x:userData) {
            System.out.println(x.getId()+"\t"+x.getPoint());
        }
    }

    public void find(String tempID) {
        boolean FLAG = false;
        for (VIP x:userData) {
            if (x.getId().equals(tempID)){
                FLAG = true;
                System.out.print("会员积分为："+x.getPoint());
            }
        }
        if (!FLAG){
            System.out.println("查找失败");
        }
    }
}
