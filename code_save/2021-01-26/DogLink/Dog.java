package DogLink;

public class Dog {
    String name;
    String species;

    public Dog(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public void show(){
        System.out.println(name+"\t\t"+species);
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
}
