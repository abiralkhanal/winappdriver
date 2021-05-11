package mavenvscode;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class notepad {
    
    public WindowsDriver<WindowsElement> driver = null;

    @BeforeMethod
    public void setUp(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "WindowsPC");

        try {
            driver = new WindowsDriver<WindowsElement> (new URL("http://127.0.0.1:4723/"), cap);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
        // setUp();
    }

    @Test(priority = 1)
    public void checkHelpAboutNowTest(){
        driver.findElementByName("Help").click();
        driver.findElementByName("About Notepad").click();
        driver.findElementByName("OK").click();
    }

    @Test(priority = 2)
    public void sendTextTest(){
        driver.findElementByName("Text Editor").sendKeys("this is my notepad automation");
        driver.findElementByName("Text Editor").clear();
    }

    @Test(priority = 3)
    public void EnterTimeAndDateTest(){
        driver.findElementByName("Edit").click();
        driver.findElementByAccessibilityId("26").click();
        String value = driver.findElementByName("Text Editor").getAttribute("Value.Value");
        System.out.println(value);
        Assert.assertTrue(value.contains("1:01 PM 4/10/2021"));
    }
    
}

