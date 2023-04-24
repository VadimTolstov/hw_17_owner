package hw_13_Jenkins_Property.config;

import org.aeonbits.owner.Config;

@Config.Sources({""})
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
}
