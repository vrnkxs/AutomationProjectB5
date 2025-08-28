package io.loop.test.day8;

import io.loop.test.base.TestBase;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class T3_new_methods_window extends TestBase {

    @Test
    public void test_new_window() throws InterruptedException {
        driver.get("https://www.google.com");

        //open a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.loopcamp.io");

        //open a new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
    }

}
