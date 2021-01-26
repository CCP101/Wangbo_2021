package Car;

public class Pickup extends Car{
    int person;
    int weight;

    public Pickup(String name, int rent, int person, int weight) {
        super(name, rent);
        this.person = person;
        this.weight = weight;
    }

    @Override
    public void print() {
        System.out.println(this.getName()+"  "+this.getRent()+"元  "+"载客量："+person+"人  "+"载货量："+weight+"吨");
    }

    public int getPerson() {
        return person;
    }

    public int getWeight() {
        return weight;
    }
}
