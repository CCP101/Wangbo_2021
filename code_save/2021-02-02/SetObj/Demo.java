package SetObj;

public class Demo {
    private String str ="2021-02-03";

    public Demo() {
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Demo{" + "str='" + str + '\'' + '}';
    }
}
