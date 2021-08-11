package android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class drag_drop_test extends CommonUtils{

    public AndroidTouchAction actions;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        driver =  androidSetUpVersion("9.0");
    }

    @Test
    public void drag_drop() {
        AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");

        actions = new AndroidTouchAction(driver);
        actions.tap(ElementOption.element(views)).perform();

        AndroidElement drag_drop =
                (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        actions.tap(ElementOption.element(drag_drop)).perform();

        AndroidElement drag = (AndroidElement) driver.findElement(By.id("drag_dot_1"));
        AndroidElement drop = (AndroidElement) driver.findElement(By.id("drag_dot_2"));
        //org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: Could not complete pointer operation.
        actions.longPress(ElementOption.element(drag))
                .waitAction().moveTo(ElementOption.element(drop))
                .release()
                .perform();
    }

    @AfterTest
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }

}

