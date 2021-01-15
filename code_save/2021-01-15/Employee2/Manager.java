package Employee2;

public class Manager extends Employee{
    String department;

    public Manager(String name, int basic, String address, String department) {
        super(name, basic, address);
        this.department = department;
    }

    @Override
    public void show() {
        System.out.println("员工姓名为："+super.getName()+"，基本工资为"+super.getBasic()+"，地址为"+super.getAddress()+"，部门为"+department);
    }
}
