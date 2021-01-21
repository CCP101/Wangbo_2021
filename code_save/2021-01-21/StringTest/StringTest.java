package StringTest;

public class StringTest {
    public static void main(String[] args) throws Exception {
        StringFunctuin stringFunctuin = new StringFunctuin();
        System.out.println(stringFunctuin.getWordNumber("aa dd cc vvv"));
        System.out.println(stringFunctuin.getWordNumber("aa dd aa cc","aa"));
        System.out.println(stringFunctuin.contain("aa dd aa cc","aa"));
    }
}
