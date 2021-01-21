package NumGene;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        NumRandom random = new NumRandom();
        Scanner input = new Scanner(System.in);
        System.out.println(random.generateRandom(input.nextInt()));
    }
}
