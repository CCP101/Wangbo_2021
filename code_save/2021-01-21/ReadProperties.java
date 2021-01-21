import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class ReadProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try{
            properties.load(new FileInputStream("src/main/resources/fileInput.properties"));
            Enumeration propertyNames = properties.propertyNames();
            while(propertyNames.hasMoreElements()){
                String key = (String)propertyNames.nextElement();
                String value = properties.getProperty(key);
                System.out.println(key+"-"+value);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
