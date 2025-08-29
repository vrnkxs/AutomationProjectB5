package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import java.util.Set;

public class T4_window_titles extends TestBase {

    @Test
    public void windowHandleTitle(){
        driver.get("https://www.google.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.loopcamp.io");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        /*
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
         */

        System.out.println("driver.getTitle(): " + driver.getTitle());

//        Set <String> windowHandles = driver.getWindowHandles();
//        for (String window : windowHandles) {
//            driver.switchTo().window(window);
//
//            if(driver.getTitle().contains("Google")) {
//                break;
//            }
//        }
        //BrowserUtils.switchWindowAndValidate(driver, "www.loopcamp.io", "Loopcamp");
        BrowserUtils.switchToWindow (driver, "Amazon");
    }

}
