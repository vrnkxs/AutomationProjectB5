package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstance;
import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * go to docuport
 * enter username
 * do NOT enter password
 * click on login button
 * verify error message - please enter password
 */
public class T1_DocuportLogin_getText {
    public static void main(String[] args) {

        //get the driver and navigate to the docuport page
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstance.DOCUPORT_TEST);

        //locate username
        WebElement username = driver.findElement(By.id("input-14"));
        username.sendKeys(DocuportConstance.USERNAME_CLIENT);

        //spy / locate / inspect login button and click
        WebElement loginButton = driver.findElement(By.className("v-btn__content"));
        loginButton.click();

        //get error message
        WebElement errorMessage = driver.findElement(By.className("v-messages__message"));
        String actualErrorMessage = errorMessage.getText();

        //validation
        if(actualErrorMessage.equals(DocuportConstance.ERROR_MESSAGE_FOR_EMPTY_PASSWORD)) {
            System.out.println("Expected error message: " + DocuportConstance.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", matches actual error message: " + actualErrorMessage + " => TEST PASS");
        } else {
            System.out.println("Expected error message: " + DocuportConstance.ERROR_MESSAGE_FOR_EMPTY_PASSWORD + ", does NOT match actual error message: " + actualErrorMessage + " => TEST FAIL");
        }
        driver.quit();
    }
}
