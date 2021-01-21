public class PoemSplit {
    public static void main(String[] args) {
        String poem = "xxx aaaa dddd ccc gggggg";
        String[] temp = poem.split(" ");
        for (String x:temp) {
            System.out.println(x);
        }
    }
}
