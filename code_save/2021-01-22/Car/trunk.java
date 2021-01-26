package Car;

public class trunk extends Car{
    int weight;

    public trunk(String name, int rent, int weight) {
        super(name, rent);
        this.weight = weight;
    }

    @Override
    public void print() {
        System.out.println(this.getName()+"  "+this.getRent()+"元  "+"载货量："+weight+"吨");
    }

    public int getWeight() {
        return weight;
    }
}
