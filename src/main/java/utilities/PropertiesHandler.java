package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesHandler {
    private static Properties prop = null;

    // a method for preparing the properties files usage
    public static Properties initializeTestConfigurations() {
        if (prop == null) {
            FileInputStream fileIP = null;
            try {
                fileIP = new FileInputStream("./src/test/resources/config/testConfig.properties");
                prop = new Properties();
                prop.load(fileIP);
            } catch (Exception e) {
                throw new RuntimeException("Can't load the properties file", e);
            }
        }
        return prop;
    }

    // getting a specific property
    public static String getProperty(String key) {
        return initializeTestConfigurations().getProperty(key);
    }
}
