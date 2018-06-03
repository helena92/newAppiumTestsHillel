package services.ted;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCases extends AppiumTestBase{

    private LoginHelper loginHelper;
    private SurprisePlaylistHelper surprisePlaylistHelper;

    @BeforeClass
    public void initHelpers(){
        loginHelper = new LoginHelper(driver);
        surprisePlaylistHelper = new SurprisePlaylistHelper(driver);
    }
    @Test
    protected void loginTest() {
        loginHelper.loginTest();
    }

    @Test
    protected void goToSurprisePlaylistSection(){
        surprisePlaylistHelper.swipeToSurprisePLSection();
    }

    @Test
    protected void videoTimeFilterTest(){
        surprisePlaylistHelper.videoTimeFilterTest();
    }

}
