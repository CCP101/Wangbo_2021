package DogArray;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog("欧欧","雪纳瑞"));
        dogList.add(new Dog("亚亚","拉布拉多"));
        dogList.add(new Dog("菲菲","拉布拉多"));
        dogList.add(new Dog("美美","雪纳瑞"));
        System.out.println("删除之前有"+dogList.size()+"只狗狗");
        dogList.remove(0);
        dogList.removeIf(e -> e.getName().equals("菲菲"));
        System.out.println("删除之后有"+dogList.size()+"只狗狗");
        for (Dog dog : dogList) {
            dog.show();
        }
        if(dogList.contains(new Dog("美美","雪纳瑞"))){
            System.out.println("集合中包含信息");
        }

    }

}
