package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertiesReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseDriver {

    private static final int DEFAULT_GLOBAL_TIMEOUT = 10000;

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static AppiumDriver instance = null;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static AppiumDriver getInstance() {
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", PropertiesReader.get("capabilities/android.properties", "deviceName"));
        capabilities.setCapability("appium:platformVersion", PropertiesReader.get("capabilities/android.properties", "platformVersion"));
        capabilities.setCapability("appium:automationName", PropertiesReader.get("capabilities/android.properties", "automationName"));
        capabilities.setCapability("appium:noReset", true);
        if(instance == null && driver.get() == null) {
            URL appiumURL;
            try {
                appiumURL = new URL(PropertiesReader.get("general.properties", "appium_url"));
                instance = new AppiumDriver(appiumURL, capabilities);
                instance.manage().timeouts().implicitlyWait(Duration.ofMillis(DEFAULT_GLOBAL_TIMEOUT));
                driver.set(instance);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static AppiumDriver get() {
        return getInstance();
    }
}
