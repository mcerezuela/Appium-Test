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
        DesiredCapabilities caps = prepareCommonCapabilities();
        caps.setCapability("platformVersion", "5.1");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }



    protected AndroidDriver androidSetUpVersion(String version) throws MalformedURLException {
        //cd %ANDROID_HOME%\tools && emulator -avd Pixel_XL_API_22
        DesiredCapabilities caps = prepareCommonCapabilities();
        caps.setCapability("platformVersion", version);
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    private DesiredCapabilities prepareCommonCapabilities() {
        DesiredCapabilities commonCaps = new DesiredCapabilities();
        commonCaps.setCapability("platformName", "Android");
        //commonCaps.setCapability("automationName", "espresso");
        commonCaps.setCapability("deviceName", "emulator-5554");
        commonCaps.setCapability("forceEspressoRebuild",true);
        commonCaps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        return commonCaps;
    }
}
