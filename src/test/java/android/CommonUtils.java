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



    protected AndroidDriver androidAppSetUpVersion(String version) throws MalformedURLException {
        //cd %ANDROID_HOME%\tools && emulator -avd Pixel_XL_API_22
        //cd %ANDROID_HOME%\tools && emulator -avd Pixel_3_XL_API_28 (V9)
        DesiredCapabilities caps = prepareCommonCapabilities();
        setUpVersion(caps, version);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos.apk");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    protected AndroidDriver androidHybridAppSetUpVersion(String version) throws MalformedURLException {
        DesiredCapabilities caps = prepareCommonCapabilities();
        setUpVersion(caps, version);
        caps.setCapability("automationName", "UiAutomator1");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("noReset", true);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/selendroid.apk");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    private DesiredCapabilities setUpVersion(DesiredCapabilities caps, String version) {
        caps.setCapability("platformVersion", version);
        return caps;
    }

    protected AndroidDriver androidChromeSetUpVersion(String version) throws MalformedURLException {
        DesiredCapabilities caps = prepareCommonCapabilities();
        setUpVersion(caps, version);
        caps.setCapability("browserName", "Chrome");
        return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    private DesiredCapabilities prepareCommonCapabilities() {
        DesiredCapabilities commonCaps = new DesiredCapabilities();
        commonCaps.setCapability("platformName", "Android");
        commonCaps.setCapability("deviceName", "emulator-5554");
        commonCaps.setCapability("forceEspressoRebuild",true);
        return commonCaps;
    }
}
