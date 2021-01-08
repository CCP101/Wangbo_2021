public class number7 {
    public static void main(String[] args) {
        int number = 1;
        while(number<100){
            if (number%7==0||number%13==0){
                System.out.print(number+"  ");
            }
            number++;
        }
    }
}
