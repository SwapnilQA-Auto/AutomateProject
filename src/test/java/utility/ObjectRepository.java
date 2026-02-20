package utility;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectRepository {
    private static final Logger logger = LogManager.getLogger(ObjectRepository.class);
    private static JSONObject objects;

    static {
        try {
            String content = new String(Files.readAllBytes(
                    Paths.get("src/test/resources/objectRepository.json")));
            objects = new JSONObject(content);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load objectRepository.json");
        }
    }

    public static By getLocator(String page, String key) {
        try {
            JSONObject pageObject = objects.getJSONObject(page);
            String locator = pageObject.getString(key);

            logger.info("Fetching locator | Page: {} | Key: {} | Locator: {}", page, key, locator);

            String[] parts = locator.split("=", 2);

            if (parts.length != 2) {
                throw new RuntimeException("Invalid locator format for key: " + key);
            }

            String type = parts[0].toLowerCase();
            String value = parts[1];

            switch (type) {
                case "id":
                    return By.id(value);
                case "name":
                    return By.name(value);
                case "xpath":
                    return By.xpath(value);
                case "css":
                    return By.cssSelector(value);
                case "classname":
                    return By.className(value);
                case "tagname":
                    return By.tagName(value);
                case "linktext":
                    return By.linkText(value);
                case "partiallinktext":
                    return By.partialLinkText(value);
                default:
                    throw new RuntimeException("Invalid locator type: " + type + " for key: " + key);
            }
        } catch (Exception e) {
            logger.error("Error fetching locator | Page: {} | Key: {}", page, key, e);
            throw e;
        }
    }


    }
