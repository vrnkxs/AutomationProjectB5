package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
https://the-internet.herokuapp.com/forgot_password
 */
public class T1_css_isDisplayed {
    public static void main(String[] args) {

        //set up driver and navigate
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();

        driver.get(GeneralConstance.HEROKUAPP_URL);

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        //print out the text of the element
        System.out.println("forgotPasswordHeading: " + forgotPasswordHeading.getText());

        //idDisplayed() boolean - will return true or false depending on the element is displayed at html
        System.out.println("forgotPasswordHeading with isDisplayed: " + forgotPasswordHeading.isDisplayed());

        if (forgotPasswordHeading.isDisplayed()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

    }
}
