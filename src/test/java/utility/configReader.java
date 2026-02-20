package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
    private Properties properties;

    public configReader(){
            properties = new Properties();
            try {
                FileInputStream file = new FileInputStream("src/test/resources/config/config.properties");
                properties.load(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("config.properties file not found!", e);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties", e);
            }
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
