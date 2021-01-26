package DogSet;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        HashSet<Dog> dogList = new HashSet<>();
        dogList.add(new Dog("欧欧"));
        dogList.add(new Dog("亚亚"));
        dogList.add(new Dog("菲菲"));
        dogList.add(new Dog("美美"));
        System.out.println("删除之前有"+dogList.size()+"只狗狗");
        dogList.remove(new Dog("菲菲"));
        System.out.println("删除之后有"+dogList.size()+"只狗狗");
        for (Dog dog : dogList) {
            dog.show();
        }
    }
}
