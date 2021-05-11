package mavenvscode;

import java.net.URL;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class createNewGroup { 
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
    public void createGroup() throws InterruptedException{
        var groupID = "100004";
        DesktopSession1.findElementByName("Create New Group").click();
        Thread.sleep(30000);
        DesktopSession1.findElementByAccessibilityId("btnNext").click();
        DesktopSession1.findElementByAccessibilityId("editCorporateID").sendKeys(groupID);
        DesktopSession1.findElementByAccessibilityId("editCorporateName").sendKeys("Test Group");
        DesktopSession1.findElementByAccessibilityId("editCorporateDBAname").sendKeys("Test DBA");
        DesktopSession1.findElementByAccessibilityId("btnNext").click();
        DesktopSession1.findElementByAccessibilityId("btnNext").click();
        DesktopSession1.findElementByAccessibilityId("btnSave").click();
        DesktopSession1.findElementByAccessibilityId("_inputBox").sendKeys(groupID);
        DesktopSession1.findElementByAccessibilityId("_okButton").click();
        DesktopSession1.findElementByName("Yes").click();
        Thread.sleep(240000);

        var a = DesktopSession1.findElementByName("Group Created");
        String ExpectedText = "Group Created";
        Assert.assertEquals(ExpectedText, a.getText());
        System.out.println("Text is expected - Group is created.");

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
