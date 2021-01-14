package Pet;

public class dog {
    private final String name;
    private final String description;
    private final int health;

    public dog(String name, String description, int health) {
        this.name = name;
        this.description = description;
        if (health>=1&&health<=100){
            this.health = health;
        }else{
            this.health = 60;
        }
    }

    public void show() {
        System.out.println("我的名字叫"+name+"，健康值是"+health+"，和主人的亲密度为0，我是一只"+description);
    }
}
