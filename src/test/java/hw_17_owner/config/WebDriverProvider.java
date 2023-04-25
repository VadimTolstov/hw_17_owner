package hw_17_owner.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProvider {


    static WebDriverConfig webConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
   public static String remoteUrl;
    public static void config() {

        Configuration.baseUrl = WebDriverProvider.webConfig.getBaseUrl();
        String[] browserAndVersion = WebDriverProvider.webConfig.getBrowserAndVersion();
        Configuration.browser = browserAndVersion[0];
        Configuration.browserVersion = browserAndVersion[1];
        Configuration.browserSize = WebDriverProvider.webConfig.getBrowserSize();
        remoteUrl = WebDriverProvider.webConfig.getRemoteUrl();
        if (remoteUrl != null) {
            Configuration.remote = "https://" + WebDriverProvider.authConfig.getRemoteUsername() + ":"
                                   + WebDriverProvider.authConfig.getRemotePassword() + "@"
                                   + remoteUrl + "/wd/hub";

        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
