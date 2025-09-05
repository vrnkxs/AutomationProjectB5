package io.loop.test.day10;

import io.loop.pages.LoopPracticeDynamicLoading1Page;
import io.loop.test.utilities.BrowserUtils;
import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class T5_dynamic_loading1 {
    /*
    1. go to https://loopcamp.vercel.app/dynamic_loading/1.html
    2. click start
    3. wait loading bar disappears
    4. validate username is displayed
    5. enter username tomsmith
    6. enter password incorrectpassword
    7. click submit button
    8. validate "Your password is invalid!" is displayed
     */
    LoopPracticeDynamicLoading1Page loopPracticeDynamicLoading1Page;

    @BeforeMethod
    public void setUpMethod(){
        loopPracticeDynamicLoading1Page = new LoopPracticeDynamicLoading1Page();
        Driver.getDriver().get(ConfigurationReader.getProperties("loop.practice"));
    }
    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }
    @Test
    public void dynamic_loading1_test(){
        BrowserUtils.loopLinkClick("Dynamic Loading");
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1Page.dynamicLoading1, 10).click();
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1Page.startButton, 10).click();
        BrowserUtils.waitForInvisibility(loopPracticeDynamicLoading1Page.loadingBar, 10);
        assertTrue(loopPracticeDynamicLoading1Page.username.isDisplayed());
        loopPracticeDynamicLoading1Page.username.sendKeys(ConfigurationReader.getProperties("dynamicLoading.username"));
        loopPracticeDynamicLoading1Page.password.sendKeys(ConfigurationReader.getProperties("dynamicLoading.incorrectPassword"));
        BrowserUtils.waitForClickable(loopPracticeDynamicLoading1Page.submitButton, 10).click();
        assertTrue(BrowserUtils.waitForVisibility(loopPracticeDynamicLoading1Page.errorMessage, 10).isDisplayed(), "Actual does NOT match expected");
    }
}
