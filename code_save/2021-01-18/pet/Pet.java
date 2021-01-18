package pet;

public abstract class Pet {
    String name;
    int health;
    int love;

    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
    }

    public abstract void print();

    public abstract void eat();
}
