package mavenvscode;

import java.net.URL;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public class addUnitToGroup { 
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
    public void addUnit() throws InterruptedException{
        DesktopSession1.findElementByName("Add New Unit to Group").click();
        Thread.sleep(30000);
        DesktopSession1.findElementByAccessibilityId("comboCorporate").click();
        DesktopSession1.findElementByName("1215 WINE BAR #7594").click();
        DesktopSession1.findElementByAccessibilityId("editUnitID").sendKeys("1");
        DesktopSession1.findElementByAccessibilityId("editUnitDbaName").sendKeys("Test Unit DBA");
        DesktopSession1.findElementByAccessibilityId("editUnitReportName").sendKeys("Test Report Name");
        DesktopSession1.findElementByAccessibilityId("editUnitDisplayName").sendKeys("Test Display Name");
        DesktopSession1.findElementByAccessibilityId("editUnitName").sendKeys("Test Corporate Name");
        DesktopSession1.findElementByAccessibilityId("btnNext").click();
        DesktopSession1.findElementByAccessibilityId("uceFinancialPeriodType").click();
        DesktopSession1.findElementByName("13 Weekly - Monday thru Sunday ").click();
        DesktopSession1.findElementByAccessibilityId("ucePayrollPeriodType").click();
        DesktopSession1.findElementByName("13 Weekly - Monday thru Sunday ").click();
        DesktopSession1.findElementByAccessibilityId("ucePayDayType").click();
        DesktopSession1.findElementByName("Monday").click();
        DesktopSession1.findElementByAccessibilityId("uceHolidayAdjustmentType").click();
        DesktopSession1.findElementByName("Day Before Holiday").click();
        DesktopSession1.findElementByAccessibilityId("btnSave").click();
        DesktopSession1.findElementByAccessibilityId("_inputBox").sendKeys("1");
        DesktopSession1.findElementByAccessibilityId("_okButton").click();
        DesktopSession1.findElementByAccessibilityId("_inputBox").sendKeys("7594");
        DesktopSession1.findElementByAccessibilityId("_okButton").click();
        DesktopSession1.findElementByName("Yes").click();

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
        System.out.println("Text is a expected – Assert passed");
    }

    
}