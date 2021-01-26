package Car;

public class bus extends Car{
    int person;

    public bus(String name, int rent, int person) {
        super(name, rent);
        this.person = person;
    }

    @Override
    public void print() {
        System.out.println(this.getName()+"  "+this.getRent()+"元  "+"载客量："+person+"人");
    }

    public int getPerson() {
        return person;
    }
}
