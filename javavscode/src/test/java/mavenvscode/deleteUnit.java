package mavenvscode;

import java.net.URL;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class deleteUnit { 
    public static WindowsDriver<WindowsElement> DesktopSession = null;
    public static WindowsDriver<WindowsElement> DesktopSession1 = null;
    public static WindowsDriver<WindowsElement> DesktopSession2 = null;

    @BeforeMethod
    public void setUp() throws InterruptedException{
        DesiredCapabilities c = new DesiredCapabilities();
        c.setCapability("app","C:\\Users\\Admin\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Restaurant Solutions\\Lester\\Lester awsqa3.appref-ms");
        try{
            WindowsDriver<WindowsElement> driver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723/"),c);
            Assert.assertNotNull(driver);
        } catch (Exception e) {
            //TODO: handle exception
        }

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "Root");
        
        try {
            DesktopSession = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), cap);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            
        }
        Thread.sleep(5000);
        login("AKhanal", "P1@n0master");
    }

    @AfterMethod
    public void cleanUp(){
        DesktopSession1.quit();
        // setUp();
    }

    @Test(priority = 1)
    public void delete() throws InterruptedException{

        DesktopSession1.findElementByName("Delete Unit").click();
        Thread.sleep(30000);
        DesktopSession1.findElementByAccessibilityId("comboDeleteUnit").click();
        DesktopSession1.findElementByName("2070 FATIMA LLC PROPERTY #0822").click();
        DesktopSession1.findElementByName("Delete").click();
        DesktopSession1.findElementByAccessibilityId("_inputBox").sendKeys("0822");
        DesktopSession1.findElementByAccessibilityId("_okButton").click();

        DesiredCapabilities cap2 = new DesiredCapabilities();
        cap2.setCapability("app", "Delete Unit?");
        
        try {
            DesktopSession2 = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), cap2);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            
        }
        DesktopSession2.findElementByAccessibilityId("Yes").click();

        var a = DesktopSession2.findElementByName("Delete Error");
        String ExpectedText = "Delete Error";
        Assert.assertEquals(ExpectedText, a.getText());
        System.out.println("Text is expected – Assert passed");

        
    }



    public void login (String _userNameTextBox, String _passwordTextBox) throws InterruptedException{
        DesktopSession.findElementByAccessibilityId("_userNameTextBox").clear();
        DesktopSession.findElementByAccessibilityId("_userNameTextBox").sendKeys(_userNameTextBox);
        DesktopSession.findElementByAccessibilityId("_passwordTextBox").sendKeys(_passwordTextBox);
        DesktopSession.findElementByAccessibilityId("_okButton").click();
        DesktopSession.quit();

        Thread.sleep(120000);

        DesiredCapabilities cap1 = new DesiredCapabilities();
        cap1.setCapability("app", "Root");
        
        try {
            DesktopSession1 = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), cap1);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            
        }
        var a = DesktopSession1.findElementByName("_layoutWorkspace");
        String ExpectedText = "_layoutWorkspace";
        Assert.assertEquals(ExpectedText, a.getText());
        System.out.println("Text is a expected – Assert passed");
    }

    
}
