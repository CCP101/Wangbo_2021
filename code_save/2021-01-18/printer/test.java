package printer;

public class test {
    public static void main(String[] args) {
        Printer black = new BlackPrinter();
        black.print();
        Printer color = new ColorPrinter();
        color.print();
    }
}
