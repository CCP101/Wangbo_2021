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
        System.out.println("�ҵ����ֽ�"+name+"������ֵ��"+health+"�������˵����ܶ�Ϊ0������һֻ"+description);
    }
}
