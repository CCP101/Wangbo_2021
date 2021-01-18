package pet;

public class Cat extends Pet{

    public Cat(String name, int health, int love) {
        super(name, health, love);
    }

    @Override
    public void print() {
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+name+",我的健康值是"+health+",我和主人的亲密程度是"+love+"。");
    }

    @Override
    public void eat() {
        System.out.println("吃猫粮");
        health+=4;
    }
}
