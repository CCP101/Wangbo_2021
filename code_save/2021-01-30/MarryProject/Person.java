package MarryProject;

import java.util.Formatter;

public class Person {
    private final String name;
    private final int age;
    private final boolean sex;      // true 女  false 男
    private String isMarried;       // true已婚 false未婚
    private Person object;          // 配偶信息
    private Person[] children;
    private final String sexPrint;
    static Formatter formatter = new Formatter(System.out);

    public Person(String name, int age, boolean sex, String isMarried) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.isMarried = isMarried;
        if (!sex){
            sexPrint = "男性";
        }else {
            sexPrint = "女性";
        }
    }

    /** 中文等宽格式化输出
     *
     */
    public void print() {
        formatter.format("%-5s\t %5d %5s %5s\n", name, age, sexPrint, isMarried);
    }

    /** 输出包含配偶及子女的个人信息并返回
     * @return 返回打印格式生成的字符串
     */
    public String printFile() {
        String temp = "";
        formatter.format("%-5s\t %5d %5s %5s\n", name, age, sexPrint, isMarried); //格式化文本在控制台输出
        temp = temp.concat(String.format("%-5s\t %5d %5s %5s\n", name, age, sexPrint, isMarried)); //拼接格式化后的文本
        if (isMarried.equals("已婚")){
            if (object!=null){
                formatter.format("├──配偶为%-5s\t\n", object.getName());
                temp = temp.concat(String.format("├──配偶为%-5s\t\n", object.getName()));
            }
            if (children!=null){
                for (Person child : children) {
                    formatter.format("├──孩子为%-5s\t\n", child.getName());
                    temp = temp.concat(String.format("├──孩子为%-5s\t\n", child.getName()));
                }
            }
        }
        return temp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

    public String getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(String isMarried) {
        this.isMarried = isMarried;
    }

    public void setObject(Person object) {
        this.object = object;
    }

    public void setChildren(Person[] children) {
        this.children = children;
    }
}
