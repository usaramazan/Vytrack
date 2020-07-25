package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        String path = "config.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            properties.load(file);

            //5- close.file
            file.close();
        } catch (IOException e) {
            System.out.println("file not found");
        }
    }

    //Our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }

}
