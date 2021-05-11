package mavenvscode;

import java.net.URL;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class lesterLogin {
    public static WindowsDriver<WindowsElement> DesktopSession = null;
    public static WindowsDriver<WindowsElement> DesktopSession1 = null;

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
    }

    @AfterMethod
    public void cleanUp(){
        DesktopSession1.quit();
        // setUp();
    }
    
    @Test(priority = 1)
    public void login() throws InterruptedException {
        
        // WindowsElement Lester = DesktopSession.findElementByName("Lester");
        // String LesterTopLevelWindowHandle = Lester.getAttribute("0xB0B5E");
        // System.out.println(LesterTopLevelWindowHandle);
        // int hex = Integer.parseInt(LesterTopLevelWindowHandle,16);
        // LesterTopLevelWindowHandle = Integer.toHexString(hex);

        // DesiredCapabilities appCapabilities = new DesiredCapabilities();
        // appCapabilities.setCapability("appTopLevelWindow", LesterTopLevelWindowHandle);
        // WindowsDriver<WindowsElement> lesterSession = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), appCapabilities); 
        // lesterSession.findElementByAccessibilityId("_userNameTextBox").clear();
        //var a = DesktopSession.findElementByName("Lester");
        //System.out.println(a);
        //var b = DesktopSession.findElementByAccessibilityId("Enter your computer logon information").getText();
        //System.out.println(b);
        DesktopSession.findElementByAccessibilityId("_userNameTextBox").clear();
        DesktopSession.findElementByAccessibilityId("_userNameTextBox").sendKeys("AKhanal");
        DesktopSession.findElementByAccessibilityId("_passwordTextBox").sendKeys("P1@n0master");
        DesktopSession.findElementByAccessibilityId("_okButton").click();
        DesktopSession.quit();

        Thread.sleep(140000);

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
        System.out.println("Text is expected – Assert passed");    
    }
}
