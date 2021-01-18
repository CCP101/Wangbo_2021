package pet;

public class Penguin extends Pet implements Play{
    int SEX_MALE;

    public Penguin(String name, int health, int love, int SEX_MALE) {
        super(name, health, love);
        this.SEX_MALE = SEX_MALE;
    }

    @Override
    public void print(){
        String sex;
        if (SEX_MALE == 1){
            sex = "雄";
        }else{
            sex = "雌";
        }
        System.out.println("宠物的自白：");
        System.out.println("我的名字叫"+name+",我的健康值是"+health+",我和主人的亲密程度是"+love+"性别是"+sex+"。");
    }

    @Override
    public void eat() {
        System.out.println("进食");
        health+=5;
    }

    @Override
    public void play(Pet pet) {
        System.out.println("玩游泳游戏");
        health-=10;
        love+=5;
    }
}
