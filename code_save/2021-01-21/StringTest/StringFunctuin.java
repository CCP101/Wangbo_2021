package StringTest;

public class StringFunctuin {
    public int getWordNumber(String s) throws Exception{
        int count = 0;
        if (s!=null&&!s.equals("")){
            String[] temp = s.split(" ");
            for (String x:temp) {
                count++;
            }
        }else {
            throw new Exception("字符串出错");
        }
        return count;
    }

    public int getWordNumber(String s1,String s2) throws Exception{
        int count = 0;
        if (s1!=null&&!s1.equals("")&&s2!=null&&!s2.equals("")){
            while(s1.contains(s2)){
                s1 = s1.substring(s1.indexOf(s2)+s2.length());
                count++;
            }
        }else {
            throw new Exception("字符串出错");
        }
        return count;
    }

    public boolean contain(String s1, String s2) throws Exception{
        boolean judge = false;
        if (s1!=null&&!s1.equals("")&&s2!=null&&!s2.equals("")){
            if(s1.contains(s2)){
                judge = true;
            }
        }else {
            throw new Exception("字符串出错");
        }
        return judge;
    }

    public static String getSubString(String s, int beginNum, int endNum) throws Exception{
        if (s!=null&&!s.equals("")){
            String begin = s.substring(0,beginNum);
            String end = s.substring(s.length()-endNum);
            return begin+end;

        }else {
            throw new Exception("字符串出错");
        }
    }

    public static String getSubString(String s1, String s2 ) throws Exception{
        if (s1!=null&&!s1.equals("")&&s2!=null&&!s2.equals("")){
            if(s1.contains(s2)){
                int num1 = s1.indexOf(s2);
                int num2 = 0;
                String process1 = s1.substring(s1.indexOf(s2)+s2.length());
                if (process1.contains(s2)){
                    while(s1.contains(s2)){
                        num2 = s2.indexOf(s2);
                        s1 = s1.substring(s1.indexOf(s2)+s2.length());
                    }
                    return s1.substring(num1,num2);
                }else {
                    throw new Exception("字符串只出现一次");
                }
            }else{
                throw new Exception("字符串未找到");
            }
        }else {
            throw new Exception("字符串出错");
        }
    }

    public static String reverse(String s1) throws Exception{
        if (s1!=null&&!s1.equals("")){
            return new StringBuffer(s1).reverse().toString();
        }else {
            throw new Exception("字符串出错");
        }
    }
}
