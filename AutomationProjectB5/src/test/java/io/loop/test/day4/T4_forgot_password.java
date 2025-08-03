package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstance;
import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
validate forgot password
identify reset password heading using css and go from parent to child
 */
public class T4_forgot_password {
    public static void main(String[] args) {

        //get driver and maximize
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();

        //go to the url
        driver.get(DocuportConstance.DOCUPORT_TEST);

        //locate the forgot password link with css and click on it

        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgetPasswordLink.click();

        //locate forgot password heading
        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        System.out.println(forgetPasswordHeading.getText());
    }
}
