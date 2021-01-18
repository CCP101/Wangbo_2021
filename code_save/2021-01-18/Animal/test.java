package Animal;

class Dog implements Animal {
    public void shout() {
        System.out.println("w!w!");
    }
}
class Cat implements Animal {
    public void shout(){
        System.out.println("m m !");
    }
}

class Store {
    public static Animal get(String choice) {
        if(choice.equalsIgnoreCase("dog")) {
            return new Dog();
        }else {
            return new Cat();
        }
    }
}


