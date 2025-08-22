package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T1_alerts extends TestBase {
     /*
    Information alert practice
    1. Open browser
    2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Validate “You successfully clicked an alert” text is displayed

    Confirmation alert practice
    1. Click to “Click for JS Confirm” button
    2. Click to OK button from the alert
    3. Verify “You clicked: Ok” text is displayed.
    4. Click to “Click for JS Confirm” button
    5. Click to Cancel button from the alert
    6. Validate “You clicked: Cancel” text is displayed.

    Prompt alert practice
    1. Click to “Click for JS Prompt” button
    2. Send "Loop Academy"
    3. Click Ok
    4. Validate "You entered: Loop Academy" text is displayed
     */

    @Test
    public void informationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickForJSAlert.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForInformationAlert.getText();
        String expected = "You successfully clicked an alert";
        assertEquals(actual, expected, "Actual does not match expected");
    }

    @Test
    public void confirmationAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirmation = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJSConfirmation.click();

        //click and accept
        driver.switchTo().alert().accept();
        WebElement successMessageForConfirmation = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForConfirmation.getText();
        String expected = "You clicked: Ok";
        assertEquals(actual,expected, "Actual does not match expected");

        //click and dismiss the alert
        clickForJSConfirmation.click();
        driver.switchTo().alert().dismiss();
        expected = "You clicked: Cancel";
        actual = successMessageForConfirmation.getText();
        assertEquals(actual, expected, "Actual does not match expected");


    }

    @Test
    public void promptAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickForJSPrompt.click();

        String text = "Loopcamp";

//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessageForPrompt = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForPrompt.getText();
        String expected = "You entered: " + text;
        assertEquals(actual, expected, "Actual does not match expected");

        clickForJSPrompt.click();
        alert.sendKeys(text);
        alert.dismiss();
        actual = successMessageForPrompt.getText();
        expected = "You entered: " + null;
        assertEquals(actual, expected, "Actual does not match expected");
    }
}
