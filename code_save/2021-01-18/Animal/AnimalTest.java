package Animal;

public class AnimalTest {
    public static void main(String[] args) {
        Animal al = Store.get("dog");
        al.shout();
    }
}