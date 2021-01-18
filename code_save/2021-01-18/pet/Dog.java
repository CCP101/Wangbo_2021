package pet;

public class Dog extends Pet implements Play{
    String type;

    public Dog(String name, int health, int love, String type) {
        super(name, health, love);
        this.type = type;
    }

    @Override
    public void print(){
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+name+",我的健康值是"+health+",我和主人的亲密程度是"+love+",我是一只"+type+"。");
    }

    @Override
    public void eat() {
        System.out.println("吃狗粮");
        health+=3;
    }

    @Override
    public void play(Pet pet) {
        System.out.println("玩接飞盘游戏");
        health-=3;
        love+=5;
    }
}
