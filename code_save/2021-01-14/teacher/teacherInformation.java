package teacher;

public class teacherInformation {
    private String name;
    private int age;
    private String sex;
    private String profession;

    public teacherInformation() {

    }

    public teacherInformation(String name, int age) {
        this.name = name;
        this.age = age;
        this.sex = "��";
        this.profession = "java";
    }

    public teacherInformation(String name, int age, String sex, String profession) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.profession = profession;
    }

    public void showInfo() {
        System.out.println("������"+name+"����"+age+"�Ա�"+sex+"רҵ"+profession);
    }
}
