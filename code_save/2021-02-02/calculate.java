import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.ArrayList;

public class calculate {
    public static void main(String[] args) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/questions.txt"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            try {
                int num = (int) engine.eval(list.get(i));
                String s = list.get(i).concat("=").concat(String.valueOf(num));
                list.set(i,s);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/results.txt"))) {
            for (String s : list) {
                System.out.println(s);
                br.write(s);
                br.newLine();
                br.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
