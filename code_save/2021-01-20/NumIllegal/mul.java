package NumIllegal;

import java.util.Scanner;

public class mul {
    public static void main(String[] args) throws BelowZero {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = mul1(a,b);
        System.out.println(c);
    }
    public static int mul1(int a, int b) throws BelowZero {
        if (a<0||b<0){
            throw new BelowZero("低于0异常");
        }
        return a*b;
    }

}
