package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {
    private final Properties properties;

    public configReader(String env){
        properties = new Properties();
        String fileName = env + ".properties"; // e.g., qa.properties

        try (InputStream input = getClass().getClassLoader().getResourceAsStream("env/" + fileName)) {
            if (input == null) {
                throw new RuntimeException("Could not find " + fileName + " in config folder");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + fileName, e);
        }
    }

    public String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            System.out.println("Property not found in " + key);
        }
        return value;
    }
    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            System.out.println("Browser property not found in config.properties!");
        } else {
            System.out.println("Browser from config: " + browser);
        }
        return browser;
    }
    public String getURL(){
        return properties.getProperty("url");
    }
}
