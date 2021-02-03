package Dog;

public class Dog {
    private String name;
    private int age;
    public String strain;
    public int health;
    public int love;

    public Dog() {
        super();
    }

    public Dog(String name, int age, String strain, int health, int love) {
        this.name = name;
        this.age = age;
        this.strain = strain;
        this.health = health;
        this.love = love;
    }
    public void show(){
        System.out.println("姓名:"+name+"\t年龄："+age+"\t品种："+strain+"\t健康值："+health+"\t友好度："+love);
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + ", strain='" + strain + '\'' + ", health=" + health + ", love=" + love + '}';
    }
}
