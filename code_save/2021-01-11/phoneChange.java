import java.util.Scanner;

public class phoneChange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("ÇëÊäÈëÌæ»»×Ö·û");
        String text = input.next();
        String[] phones = {"iphone4","iphones4s","iphone5",null};
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].equals("iphone5")){
                phones[i]=text;
            }
        }
        for (String x:phones) {
            System.out.println(x);
        }
    }
}
