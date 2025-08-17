package io.loop.test.day5;

import io.loop.test.utilities.DocuportConstance;
import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.*;

/*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset-password
    5. validate - Enter the email address associated with your account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate send button is displayed
    8. validate cancel button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */
public class T2_xpath_getText {
    public static void main(String[] args) throws InterruptedException {

        //1, 2 openchromeand navigate to docuport
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstance.DOCUPORT_TEST);

        //click on forgot password link
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        //validate url contains: reset-password
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(DocuportConstance.FORGOT_PASSWORD_URL)) {
            System.out.println("test pass");
        } else {
            System.out.println("test fail");
        }

        //validate - Enter the email address associated with your account
        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstance.RESET_PASSWORD_MESSAGE)) {
            System.out.println("test pass");
        } else {
            System.out.println("test fail");
        }

        //enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstance.EMAIL_FOR_RESET_PASSWORD);

        //validate send button is displayed
        //validate cancel button is displayed

        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        if (sendButton.isDisplayed()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        WebElement cancelButton = driver.findElement(By.xpath("//a[@href='/login']"));

        if (cancelButton.isDisplayed()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }

        //click send button
        sendButton.click();

        //Thread.sleep(5000);

        //validate - We've sent you an email with a link to reset your password. Please check your email
        WebElement successMessage = null;
        try {
            successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Thread.sleep(5000);
            successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        }

        System.out.println("successMessage text: " + successMessage.getText());

        Thread.sleep(10000);
        try {
            System.out.println("successMessage text: " + successMessage.getText());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            System.out.println("Element is not here anymore");
        }

    }
}
