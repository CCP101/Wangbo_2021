package MarryProject;

import java.io.*;
import java.util.*;

public class MarrySystem {
    LinkedList<Person> personLinkedList = new LinkedList<>();
    LinkedList<Person> childLinkedList = new LinkedList<>();
    static Formatter formatter = new Formatter(System.out);
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    /** 初始化list，从文件中导入数据
     * @throws IOException 文件读取
     */
    public void initInput() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/marry.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tempUser = line.split("\\|");
                int age = Integer.parseInt(tempUser[1]);
                boolean sexFlag = false;
                if (tempUser[2].equals("true")) sexFlag = true;
                Person temp = new Person(tempUser[0], age, sexFlag, tempUser[3]);
                personLinkedList.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Person person : personLinkedList) {
            person.print();
        }
        System.out.println("系统数据导入完成");
    }

    public void cp() {
        int peopleNum = personLinkedList.size();
        int p1 = random.nextInt(peopleNum);
        int p2 = random.nextInt(peopleNum);
        Person person1 = personLinkedList.get(p1);
        Person person2 = personLinkedList.get(p2);
        if (person1.isSex()){
            Person temp = person1;
            person1 = person2;
            person2 = temp;
        }
        boolean result = judge(person1,person2);
        if (result){
            int babyNum = random.nextInt(3);//0,1,2
            person1.setObject(person2);
            person2.setObject(person1);
            person1.setIsMarried("已婚");
            person2.setIsMarried("已婚");
            System.out.println("生育数量为: "+babyNum);
            if (babyNum!=0){
                ArrayList<Person> babyList = new ArrayList<>();
                for (int i = 1; i <= babyNum; i++) {
                    System.out.print("请输入新生儿"+i+"名称：");
                    String tempName = input.next();
                    String name = person1.getName().substring(0,1).concat(tempName);
                    boolean sex = random.nextBoolean();
                    Person baby = new Person(name,0,sex,"未婚");
                    childLinkedList.add(baby);
                    babyList.add(baby);
                }
                Person[] babyArray = babyList.toArray(new Person[0]);
                person1.setChildren(babyArray);
                person2.setChildren(babyArray);
            }else{
                System.out.println("未有生育");
            }
        }
    }

    private boolean judge(Person p1, Person p2) {
        System.out.println("随机两人为：");
        if (p1 == p2) {
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 不能跟自己结婚");
            return false;
        }
        if (p1.isSex()==p2.isSex()){
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 同性不能结婚");
            return false;
        }
        if (p1.getIsMarried().equals("已婚")||p2.getIsMarried().equals("已婚")){
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 已婚的不能结婚");
            return false;
        }
        if (p1.getAge()<23||p2.getAge()<20){
            formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
            System.out.println("错误❌ 年龄不符合要求");
            return false;
        }
        formatter.format("%-5s\t %5s\n", p1.getName(), p2.getName());
        System.out.println("满足条件✔ 可以结婚");
        return true;
    }

    public void end() throws IOException {
        BufferedWriter br = null;
        try{
            br = new BufferedWriter(new FileWriter("src/main/resources/output.txt"));
            for (Person person : personLinkedList) {
                String text = person.printFile();
                br.write(text);
                br.flush();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null ) {
                br.close();
            }
        }

    }
}
