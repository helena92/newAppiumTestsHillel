package services.ted;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import java.util.List;

public class SurprisePlaylistHelper {
    private final AndroidDriver <MobileElement> driver;

    public SurprisePlaylistHelper(AndroidDriver <MobileElement> driver) {
        this.driver = driver;
    }

    public void swipeToSurprisePLSection(){
        Tools.swipeByCoords(109, 1370, 882, 1370);
        MobileElement sectionName = driver.findElementById("sectionText");
        Assert.assertEquals(sectionName.getText(), "Surprise me");
    }


    public void videoTimeFilterTest() {
        MobileElement filteredSection = driver.findElementByXPath("//android.widget.TextView[@text='Jaw-dropping']");
        filteredSection.click();
        MobileElement selectedTimeEl = driver.findElementById("timeTextView");
        int selectedSeconds = Integer.parseInt(selectedTimeEl.getText())*60;
        MobileElement continueBtn = driver.findElementById("surpriseMeAction");
        continueBtn.click();
        List<MobileElement> videos = driver.findElementsById("talkListItemRow");
        for (MobileElement video : videos) {
            String videoDurationText = video.findElementById("talksListTimeTextView").getText();
            String[] splitTime = videoDurationText.split(":");
            int videoDurationSeconds = Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
            Assert.assertTrue(videoDurationSeconds <= selectedSeconds);
        }
    }

}
