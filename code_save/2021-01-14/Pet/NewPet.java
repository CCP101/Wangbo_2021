public class NewPet {
    private final String name;
    private final String description;

    public NewPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void show() {
        System.out.println("我的名字叫"+name+"，健康值是100，和主人的亲密度为20，性别是"+description);
    }
}
