package mavenvscode;

import java.net.URL;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class editGroup { 
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
        login("AKhanal", "P1@n0master");
    }

    @AfterMethod
    public void cleanUp() throws InterruptedException{
        DesktopSession1.close();
        // setUp();
    }

    @Test(priority = 1)
    public void editUnit() throws InterruptedException{
        Actions action = new Actions(DesktopSession1);
        WindowsElement element = DesktopSession1.findElementByName("Edit Unit");
        action.doubleClick(element).perform();
        Thread.sleep(30000);
        DesktopSession1.findElementByAccessibilityId("uteUnitDBAname").clear();
        DesktopSession1.findElementByAccessibilityId("uteUnitDBAname").sendKeys("HAPA SUSHI GRILL BOULDER");
        DesktopSession1.findElementByAccessibilityId("uteUnitReportName").clear();
        DesktopSession1.findElementByAccessibilityId("uteUnitReportName").sendKeys("HAPA SUSHI GRILL BOULDER");
        DesktopSession1.findElementByAccessibilityId("uteUnitDisplayName").clear();
        DesktopSession1.findElementByAccessibilityId("uteUnitDisplayName").sendKeys("HAPA SUSHI GRILL BOULDER");
        DesktopSession1.findElementByName("Settings").click();
        DesktopSession1.findElementByAccessibilityId("uceDepositFrequencyID").click();
        DesktopSession1.findElementByAccessibilityId("BiWeekly").click();
        DesktopSession1.findElementByName("Basics").click();
        DesktopSession1.findElementByName("Save").click();
        Thread.sleep(10000);

        //String value = DesktopSession1.findElementByAccessibilityId("uteUnitDBAname").getAttribute("Value.Value");
        //System.out.println(value);
        //Assert.assertTrue(value.contains("HAPA SUSHI GRILL BOULDER"));
        //System.out.println("Value is found. Edit successfull");
        

    }
    
    public void login (String _userNameTextBox, String _passwordTextBox) throws InterruptedException{
        DesktopSession.findElementByAccessibilityId("_userNameTextBox").clear();
        DesktopSession.findElementByAccessibilityId("_userNameTextBox").sendKeys("AKhanal");
        DesktopSession.findElementByAccessibilityId("_passwordTextBox").sendKeys("P1@n0master");
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
        System.out.println("Text is expected – Login successfull");
    }

    
}
