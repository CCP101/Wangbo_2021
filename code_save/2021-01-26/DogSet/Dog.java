package DogSet;

public class Dog {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog){
            Dog question = (Dog) o;
            return this.name.equals(question.getName());
        }
        return false;
    }
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
