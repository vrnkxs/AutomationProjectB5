package io.loop.test.day6;

import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.time.Duration;

public class T5_simple_dropdown {
    /*
    1. Open Chrome browse
    2. Go to http://the-internet.herokuapp.com/dropdown
    3. Verify “Dropdown list” default selected value is correct - Expected: “Please select an option”
     */
        WebDriver driver;
        String expected = "Please select an option";
        String actual;

        @BeforeMethod
        public void setUpMethod() {
            driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
            driver.manage().window().maximize();
        }

        @AfterClass
        public void tearDownMethod() {
            driver.close();
        }

        @Test(priority = 2)
        public void dropDown_test() {
            driver.get("http://the-internet.herokuapp.com/dropdown");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //create the dropdown
            //WebElement dropdownElement = driver.findElement(By.xpath(" dropdown"));
            //Select dropdown = new Select(dropdownElement);

            Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
            actual = dropdown.getFirstSelectedOption().getText();
            assertEquals(actual, expected, "Actual: " + actual + " does NOT match expected: " + expected);
        }


}
