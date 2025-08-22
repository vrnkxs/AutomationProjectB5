package io.loop.test.day6;

import io.loop.test.utilities.DocuportConstance;
import io.loop.test.utilities.GeneralConstance;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_HTML_dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver(GeneralConstance.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstance.DOCUPORT_TEST);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.close();
    }

    @Test
    public void htmlDropdown() {
        WebElement username = driver.findElement(By.xpath("//input[@id='input-14']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-15']"));
        WebElement signIn = driver.findElement(By.className("v-btn__content"));

        username.sendKeys(DocuportConstance.USERNAME_CLIENT);
        password.sendKeys(DocuportConstance.PASSWORD);
        signIn.click();

        WebElement dropdown = driver.findElement(By.xpath("//input[@id='input-86']"));
        dropdown.click();

        //WebElement dropdown2 = driver.findElement(By.xpath("//span[contains(text(),'FeyruzTheBest5')]"));
        //dropdown2.click();

        WebElement warren = driver.findElement(By.xpath("//span[contains(text(),'Warren')]"));
        warren.click();
    }

}
