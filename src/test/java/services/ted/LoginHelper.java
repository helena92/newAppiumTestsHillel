package services.ted;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

public class LoginHelper {
    private final AndroidDriver <MobileElement> driver;

    public LoginHelper(AndroidDriver <MobileElement> driver) {
        this.driver = driver;
    }

    public void loginTest() {
        MobileElement profile = driver.findElementByAccessibilityId("My talks");
        profile.click();
        MobileElement loginSection = driver.findElementById("myTalksLoggedOutActionLogin");
        loginSection.click();
        MobileElement emailInput = driver.findElementById("user_email");
        emailInput.sendKeys("echornobai@intersog.com");
        MobileElement pwdInput = driver.findElementById("user_password");
        pwdInput.sendKeys("testpass");
        MobileElement logInBtn = driver.findElementByXPath("//android.widget.Button[@text='Log in']");
        logInBtn.click();
        MobileElement OKButton = driver.findElementById("button2");
        OKButton.click();
        MobileElement loggedInTitle = driver.findElementById("myTalksLoggedInTitle");
        Assert.assertEquals(loggedInTitle.getText(), "Elena Chornobai ");
    }

}
