package MarryProject;

import java.io.*;
import java.util.*;

public class MarrySystem {
    LinkedList<Person> personLinkedList = new LinkedList<>();
    LinkedList<Person> childLinkedList = new LinkedList<>();
    static Formatter formatter = new Formatter(System.out);
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    /** 初始化，从文件中导入数据并创建对象加入list中
     * @throws IOException 文件读取
     */
    public void initInput() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/marry.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tempUser = line.split("\\|"); //以|作为分隔符并创建Person类
                int age = Integer.parseInt(tempUser[1]);
                boolean sexFlag = false;
                if (tempUser[2].equals("true")) sexFlag = true;
                Person temp = new Person(tempUser[0], age, sexFlag, tempUser[3]);
                personLinkedList.add(temp); //加入链表中
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Person person : personLinkedList) {
            person.print();
        }
        System.out.println("系统数据导入完成");
        System.out.println("──────────────────────────────");
    }

    /** 随机配对，若成功创建孩子对象并修改父母属性
     *
     */
    public void cp() {
        int peopleNum = personLinkedList.size();
        int p1 = random.nextInt(peopleNum);
        int p2 = random.nextInt(peopleNum);
        Person person1 = personLinkedList.get(p1);
        Person person2 = personLinkedList.get(p2);
        String[] nameChoose = {"三","四","五","六"};
        if (person1.isSex()){
            Person temp = person1;
            person1 = person2;
            person2 = temp;
        } // 保证在正常情况下，男性在前女性在后，便于条件判断及姓氏获取
        boolean result = judge(person1,person2);
        if (result){
            int babyNum = random.nextInt(3); //0,1,2
            person1.setObject(person2);
            person2.setObject(person1);
            person1.setIsMarried("已婚");
            person2.setIsMarried("已婚"); //设置夫妇双方属性
            System.out.println("生育数量为: "+babyNum);
            if (babyNum!=0){
                Person[] babyArray = new Person[babyNum]; //创建数组
                for (int i = 1; i <= babyNum; i++) {
                    int index = i-1;
                    int indexName = random.nextInt(4);
                    String name = person1.getName().substring(0,1).concat(nameChoose[indexName]); //拼接姓名
                    boolean sex = random.nextBoolean(); //随机性别
                    Person baby = new Person(name,0,sex,"未婚");
                    childLinkedList.add(baby);
                    babyArray[index] = baby;
                }
                person1.setChildren(babyArray);
                person2.setChildren(babyArray);
            }else{
                System.out.println("未有生育"); //丁克家庭
            }
        }
    }

    /** 传入两个Person对象，判断是否合规
     * @param p1 男性对象 （一男一女情况下）
     * @param p2 女性对象
     * @return 判断是否合法的结果
     */
    private boolean judge(Person p1, Person p2) {
        boolean result = false;
        System.out.println("随机两人为：");
        if (p1 == p2) {
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 不能跟自己结婚");
        } else if (p1.isSex() == p2.isSex()) {
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 同性不能结婚");
        } else if (p1.getIsMarried().equals("已婚") || p2.getIsMarried().equals("已婚")) {
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 已婚的不能结婚");
        } else if (p1.getAge() < 23 || p2.getAge() < 20) {
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 年龄不符合要求");
        } else {
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("满足条件✔ 可以结婚");
            result = true;
        }
        return result;
    }

    /** 打印结果并写到本地文件
     * @throws IOException 文件写入
     */
    public void end() throws IOException {
        System.out.println("──────────────────────────────");
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/output.txt"))) {
            for (Person person : personLinkedList) {
                String text = person.printFile();
                br.write(text);
                br.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
