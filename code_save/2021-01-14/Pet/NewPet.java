public class NewPet {
    private final String name;
    private final String description;

    public NewPet(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void show() {
        System.out.println("�ҵ����ֽ�"+name+"������ֵ��100�������˵����ܶ�Ϊ20���Ա���"+description);
    }
}
