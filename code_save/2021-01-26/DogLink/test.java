package DogLink;

import DogArray.Dog;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        LinkedList<Dog> dogList = new LinkedList<>();
        dogList.add(new DogArray.Dog("欧欧","雪纳瑞"));
        dogList.add(new DogArray.Dog("亚亚","拉布拉多"));
        dogList.add(new DogArray.Dog("菲菲","拉布拉多"));
        dogList.add(new DogArray.Dog("美美","雪纳瑞"));
        System.out.println("删除之前有"+dogList.size()+"只狗狗");
        dogList.removeLast();
        dogList.removeFirst();
        System.out.println("删除之后有"+dogList.size()+"只狗狗");
        for (DogArray.Dog dog : dogList) {
            dog.show();
        }
    }
}
