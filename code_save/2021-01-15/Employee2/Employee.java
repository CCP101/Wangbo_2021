package Employee2;

public class Employee {
    private final String name;
    private final int basic;
    private final String address;

    public Employee(String name, int basic, String address) {
        this.name = name;
        this.basic = basic;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getBasic() {
        return basic;
    }

    public String getAddress() {
        return address;
    }

    public void show(){
        System.out.println("员工姓名为："+name+"，基本工资为"+basic+"，地址为"+address);
    }
}
