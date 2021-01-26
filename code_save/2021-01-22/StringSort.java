import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        String str = "svd9876fsb543fdg210";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp>='0'&&temp<='9'){
                int even = Integer.parseInt(str.substring(i,i+1));
                if (even%2==0){
                    sb.append(even);
                }
            }
        }
        str = new String(sb);
        int[] intArray = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            intArray[i] = Integer.parseInt(str.substring(i,i+1));
        }
        for(int i = 0; i < intArray.length-1; i++){
            for(int j = 0; j<intArray.length-1-i; j++){
                if(intArray[j] > intArray[j+1]){
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}
