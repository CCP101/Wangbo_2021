public class printFigure {
    public static void main(String[] args) {
        printRectangle();
        printTriangle();
        printInvertedTriangle();
        printMultiplication();
    }

    private static void printMultiplication() {
        for(int i=1;i<=9;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(j+"¡Á"+i+"="+i*j+"\t");
            }
            System.out.println();
        }
    }

    private static void printInvertedTriangle() {
        for(int i = 5; i >= 1; i --){
            for(int j = 5; j > i; j --){
                System.out.print("   ");
            }
            for(int j = i; j >= 1; j --){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printTriangle() {
        for(int i = 1; i <= 5; i ++){
            for(int j = 1; j <= i; j ++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void printRectangle() {
        for (int i = 1; i <= 5; i++) {
            System.out.print(" * ");
            for (int j = 1; j <= 4; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
