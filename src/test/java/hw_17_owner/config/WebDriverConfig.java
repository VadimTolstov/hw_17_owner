package hw_17_owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties" //запуск через терминал gradle clean test -Denv='remote'
})
public interface WebDriverConfig extends Config {

    @Key("browserAndVersion")
    @DefaultValue("chrome,112.0")
    String [] getBrowserAndVersion();

    @Key("base_url")
    @DefaultValue("https://demoqa.com")
    String getBaseUrl();

    @Key("browser_size")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("selenoid_url")
    String getRemoteUrl();
}
