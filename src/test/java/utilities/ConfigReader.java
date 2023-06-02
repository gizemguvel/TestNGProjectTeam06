package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //This class will read configuration.properties file using java
    //create properties object
    private static Properties properties;

    //static block
    static {
        String path= "src/test/java/configuration.properties";
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //create method that accepts key and returns value
    public static String getProperty(String key){
        String value=properties.getProperty(key);
        return value;
    }
}
