package utility;

import org.json.JSONObject;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ObjectRepository {
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

        JSONObject pageObject = objects.getJSONObject(page);
        String locator = pageObject.getString(key);

        if (locator.startsWith("id="))
            return By.id(locator.replace("id=", ""));
        else if (locator.startsWith("xpath="))
            return By.xpath(locator.replace("xpath=", ""));
        else if (locator.startsWith("name="))
            return By.name(locator.replace("name=", ""));
        else
            throw new RuntimeException("Invalid locator type for key: " + key);
    }
}

