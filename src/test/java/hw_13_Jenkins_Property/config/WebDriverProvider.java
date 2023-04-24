package hw_13_Jenkins_Property.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {
    public static void config() {

        Configuration.remote = "https://user1:1234@" + System.getProperty("selenoid_url", "selenoid.autotests.cloud/wd/hub");
        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");


        //Включаем VNC окошка в окошке и  включаем запись видео Video
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
