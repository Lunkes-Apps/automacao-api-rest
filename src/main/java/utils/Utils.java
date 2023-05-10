package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    public static String getProperty(String key) {
        Properties prop = new Properties();
        try {
            prop.load(Files.newInputStream(Paths.get("src/main/resources/config.properties")));
            return prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
