package android;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class FirstAndroidTest extends CommonUtils{

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver = androidAppSetUpVersion("9.0");
    }

    @Test
    public void click_App_Button() {
        // code
        driver.findElementByAccessibilityId("App").click();

    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}
