package android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonUtils {
    public AppiumDriver driver;

    protected AndroidDriver androidSetUp() throws MalformedURLException {
        //cd %ANDROID_HOME%\tools && emulator -avd Pixel_XL_API_22
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "espresso");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "5.1");
        caps.setCapability("forceEspressoRebuild",true);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    protected AndroidDriver androidSetUpVersion10() throws MalformedURLException {
        //cd %ANDROID_HOME%\tools && emulator -avd Pixel_XL_API_22
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "espresso");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("forceEspressoRebuild",true);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }
}
