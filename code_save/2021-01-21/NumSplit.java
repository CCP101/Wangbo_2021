public class NumSplit {
    public static void main(String[] args) {
        String number = "1234567895263";
        StringBuffer buffer = new StringBuffer(number);
        for(int i = number.length()-3;i>=0;i-=3 ){
            buffer.insert(i, ",");
        }
        System.out.println(buffer);
    }
}
