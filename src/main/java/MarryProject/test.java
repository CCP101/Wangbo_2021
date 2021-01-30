package MarryProject;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Thread marry = new Thread(new MarryThread());
        marry.start();
    }
}
