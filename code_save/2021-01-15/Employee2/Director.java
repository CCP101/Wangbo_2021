package Employee2;

public class Director extends Employee{

    int transportAllowance;

    public Director(String name, int basic, String address, int transportAllowance) {
        super(name, basic, address);
        this.transportAllowance = transportAllowance;
    }

    @Override
    public void show() {
        System.out.println("员工姓名为："+super.getName()+"，基本工资为"+super.getBasic()+"，地址为"+super.getAddress()+"，津贴为"+transportAllowance);
    }
}
