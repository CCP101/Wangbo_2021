package Car;

import java.util.Scanner;
import java.util.Vector;

public class ManageSystem {
    private static final Vector<Car> car = new Vector<>();
    private int personSum;
    private int weightSum;
    private int moneySum;

    public void init(){
        Car c1 = new bus("东方标志",120,5);
        car.add(c1);
        Car c2 = new trunk("小货车\t",150,5);
        car.add(c2);
        Car c3 = new bus("奔驰\t\t",200,6);
        car.add(c3);
        Car c4 = new Pickup("皮卡\t\t",180,2,4);
        car.add(c4);
        Car c5 = new trunk("大型货车",220,3);
        car.add(c5);
        Car c6 = new bus("小型货车",160,9);
        car.add(c6);
    }

    public void print(){
        System.out.println("可供选择的车如下：");
        System.out.println("序号\t\t车名\t\t日租金\t容量");
        int num = 0;
        for (Car temp:car) {
            num++;
            System.out.print("NUM."+num+"\t");
            temp.print();
        }
    }

    public void reservation() {
        System.out.println("请输入您需要租车的数量");
        Scanner input = new Scanner(System.in);
        int carNum = input.nextInt();
        int tempSum = 0;
        for (int i = 0; i < carNum; i++) {
            System.out.println("请选择您需要的车的编号");
            int carID = input.nextInt();
            Car temp = car.elementAt(carID-1);
            if (temp instanceof bus){
                tempSum+=temp.getRent();
                personSum+=((bus) temp).getPerson();
            }else if (temp instanceof trunk){
                tempSum+=temp.getRent();
                weightSum+=((trunk) temp).getWeight();
            }else if(temp instanceof Pickup){
                tempSum+=temp.getRent();
                personSum+=((Pickup) temp).getPerson();
                weightSum+=((Pickup) temp).getWeight();
            }
        }
        System.out.println("请输入需要租车的天数：");
        int day = input.nextInt();
        moneySum = tempSum*day;
        System.out.println("总载客量："+personSum+"人\t总载货量："+weightSum+"吨\t总价格："+moneySum+"元");
    }
}
