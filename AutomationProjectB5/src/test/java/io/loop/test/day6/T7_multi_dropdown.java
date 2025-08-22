package io.loop.test.day6;

import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.time.Duration;
import java.util.List;

public class T7_multi_dropdown {
        /*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. Select all the options from multiple select dropdown.
    4. Print out all selected values.
    5. Deselect all values.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void multiSelect() {
        //create dropdown
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));

        //there is a method that tells us thet dropdown is multiselect or not
        assertTrue(dropdown.isMultiple(), "Dropdown is not multi select");

//        dropdown.selectByIndex(0);
//        dropdown.selectByValue("saab");
//        dropdown.selectByVisibleText("Opel");
//        dropdown.deSelectByContainsVisibleText("Au");

        //get all options and assign them to the list of elements
        List<WebElement> options;
        options = dropdown.getOptions();

//        for (WebElement option : options) {
//            option.click();
//            System.out.println("option.getText() = " + option.getText());
//        }
//        options.forEach(option -> {
//            option.click();
//            System.out.println("option.getText()" + option.getText());
//        });

        options.forEach(WebElement::click);
        dropdown.deselectAll();
      }
}
