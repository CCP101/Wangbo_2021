package Game;

public class Level {
    private final int levelNo;
    private final int strLength;
    private final int strTimes;
    private final int timeLimit;
    private final int perScore;
    private final boolean signExist;

    /**
     * @param levelNo 级别号
     * @param strLength 输出字符串长度
     * @param strTimes 输出字符串次数
     * @param timeLimit 时间限制
     * @param perScore 每次得分
     * @param signExist 是否出现符号
     */
    public Level(int levelNo, int strLength, int strTimes, int timeLimit, int perScore, boolean signExist) {
        this.levelNo = levelNo;
        this.strLength = strLength;
        this.strTimes = strTimes;
        this.timeLimit = timeLimit;
        this.perScore = perScore;
        this.signExist = signExist;
    }

    /** 输出关卡信息提示
     *
     */
    public void showLevelInformation(){
        String sign;
        if (signExist){
            sign = "是";
        }else{
            sign = "否";
        }
        System.out.println("当前关卡等级为"+levelNo);
        System.out.print("本关卡单个字符串长度为"+strLength+"，输出字符串次数"+strTimes);
        System.out.println(",时间限制为"+timeLimit+"，单次正确得分为"+perScore+",是否会出现符号："+sign);
    }

    public int getLevelNo() {
        return levelNo;
    }

    public int getStrLength() {
        return strLength;
    }

    public int getStrTimes() {
        return strTimes;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getPerScore() {
        return perScore;
    }

    public boolean isSignExist() {
        return signExist;
    }
}
