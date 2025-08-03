package io.loop.test.day4;

import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.LoopCampConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    go to url: https://loopcamp.vercel.app/registration_form.html
    validate header text expected:  Registration form
    validate placeholder attribute value for first name expected - first name
     */
public class T2_getText_getAttribute {
    public static void main(String[] args) {

        //go to the url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();
        driver.navigate().to(LoopCampConstance.REGISTRATION_FORM_URL);

        //spy / locate the element - header
        WebElement header = driver.findElement(By.tagName("h2"));

        //use getText() method
        String actualHeaderForForm = header.getText();

        //validation
        if (actualHeaderForForm.equals(LoopCampConstance.EXPECTED_HEADER_FOR_FORM)) {
            System.out.println("Expected header for form: \"" + LoopCampConstance.EXPECTED_HEADER_FOR_FORM + "\", matches actual header for form: \"" + actualHeaderForForm + "\" => TEST PASS");
        } else {
            System.out.println("Expected header for form: \"" + LoopCampConstance.EXPECTED_HEADER_FOR_FORM + "\", does NOT match actual header for form: \"" + actualHeaderForForm + "\" => TEST FAIL");
        }

        //use getAttribute method which will return the value of the attribute, not the text
        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));
        String actualPlaceholderForFirstName = firstNamePlaceholder.getAttribute("placeholder");

        //validation
        if (actualPlaceholderForFirstName.equals(LoopCampConstance.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME)) {
            System.out.println("Expected placeholder for form: \"" + LoopCampConstance.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME + "\", matches actual placeholder for form: \"" + actualPlaceholderForFirstName + "\" => TEST PASS");
        } else {
            System.out.println("Expected placeholder for form: \"" + LoopCampConstance.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME + "\", does NOT match actual placeholder for form: \"" + actualPlaceholderForFirstName + "\" => TEST FAIL");
        }

    }
}
